package com.ncr.dbk.niis;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.options.Validation.Required;

public interface PubSubOptions extends PipelineOptions, StreamingOptions{
	    
	    @Description("The Cloud Pub/Sub topic to read from.")
	    @Required
	    String getInputTopic();

	    void setInputTopic(String value);
	    
	    @Description("The Cloud Pub/Sub topic to write into.")
	    @Required
		String getOutputTopic();
	    
	    void setOutputTopic(String value);
	    
	    @Description("The Cloud Pub/Sub topic for error log.")
	    @Required
		String getErrorTopic();
	    
	    void setErrorTopic(String value);

}
