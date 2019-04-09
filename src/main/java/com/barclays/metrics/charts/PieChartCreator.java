package com.barclays.metrics.charts;

import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PieChartCreator {

	private String responseData;

	public PieChartCreator(String responseData) {
		this.responseData = responseData;
	}

	public JSONObject getData() throws JsonParseException, JsonMappingException, JSONException, IOException {
		return getSeriesJsonFromResponse();
	}

	private JSONObject getSeriesJsonFromResponse()
			throws JSONException, JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> dataMap = mapper.readValue(responseData, new TypeReference<Map<String, Integer>>() {
		});
		JSONObject seriesJson = new JSONObject();
		JSONArray dataArray = new JSONArray();
		for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
			JSONObject dataJson = new JSONObject();
			dataJson.put("name", entry.getKey());
			dataJson.put("y", entry.getValue());
			dataArray.put(dataJson);
		}

		seriesJson.put("data", dataArray);
		return seriesJson;
	}

}
