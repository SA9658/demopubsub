package com.ncr.dbk.niis.model.operations;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DIISToMapGenerator implements Serializable {
	public Map<String, String> getMap(String payload) {
		Map<String, String> map = new HashMap<>();
		payload = payload.replace("<DI><IID>", "<DINUM>");
		payload = payload.replaceAll(">", "=");
		String[] payloads = payload.toString().split("<");
		for (int i = 1; i < payloads.length; i++) {
			String[] keyValues = payloads[i].split("=");
			map.put(keyValues[0], keyValues[1]);
		}
		return map;
	}
}
