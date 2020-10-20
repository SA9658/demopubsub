package com.ncr.dbk.niis;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.TupleTag;
import org.apache.beam.sdk.values.TupleTagList;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ncr.dbk.niis.model.TransactionBean;
import com.ncr.dbk.niis.model.operations.DIISToMapGenerator;
import com.ncr.dbk.niis.model.operations.TransactionBeanGenerator;

@SpringBootApplication
public class DataFlowSubscriberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataFlowSubscriberServiceApplication.class, args);

		PubSubOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(PubSubOptions.class);

		options.setStreaming(true);

		Pipeline pipeline = Pipeline.create(options);

		final TupleTag<String> successTag = new TupleTag<String>() {
		};
		final TupleTag<String> failureTag = new TupleTag<String>() {
		};
		PCollection<String> input = pipeline.apply("Read PubSub Messages",
				PubsubIO.readStrings().fromTopic(options.getInputTopic()));

		PCollectionTuple outputTuple = input.apply(ParDo.of(new DoFn<String, String>() {
			@ProcessElement
			public void processElement(ProcessContext c) {

				Logger logger = Logger.getLogger(DataFlowSubscriberServiceApplication.class.getName());

				try {
					c.output(successTag, c.element());
				} catch (Exception e) {
					logger.severe("Failed to process input {} -- adding to dead letter file");
					c.output(failureTag, c.element());
				}
			}
		}).withOutputTags(successTag, TupleTagList.of(failureTag)));
		outputTuple.get(failureTag).apply("Write Files to pubsub", PubsubIO.writeStrings().to(options.getErrorTopic()));

		outputTuple.get(successTag).apply("DIIS to NIIS Conversion", ParDo.of(new DoFn<String, String>() {
			@ProcessElement
			public void processElement(@Element String data, OutputReceiver<String> out)
					throws JsonGenerationException, JsonMappingException, IOException {
				TransactionBeanGenerator tbg = new TransactionBeanGenerator();
				DIISToMapGenerator d2M = new DIISToMapGenerator();
				Map<String, String> payloadMap = d2M.getMap(data);
				TransactionBean tBean = tbg.getBean(payloadMap);
				ObjectMapper mapper = new ObjectMapper();
				String payload = mapper.writeValueAsString(tBean);
				out.output(payload);
			}
		})).apply("Write to PubSub", PubsubIO.writeStrings().to(options.getOutputTopic()));

		pipeline.run().waitUntilFinish();

	}

}