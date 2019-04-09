package com.barclays.metrics.charts;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrendComparisonChartCreator {

	private String responseData;

	public TrendComparisonChartCreator(String responseData) {
		this.responseData = responseData;
	}

	public JSONObject getData() throws JsonParseException, JsonMappingException, JSONException, IOException {
		return getSeriesJsonFromResponse();
	}

	private JSONObject getSeriesJsonFromResponse()
			throws JSONException, JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, List<Integer>> dataMap = mapper.readValue(responseData,
				new TypeReference<Map<String, List<Integer>>>() {
				});

		JSONObject seriesJson = new JSONObject();
		JSONArray dataArray = new JSONArray();
		for (Map.Entry<String, List<Integer>> entry : dataMap.entrySet()) {
			JSONObject dataJson = new JSONObject();
			dataJson.put("name", entry.getKey());
			dataJson.put("data", entry.getValue());
			dataArray.put(dataJson);
		}

		seriesJson.put("dataArray", dataArray);
		seriesJson.put("categories", getXAxisJsonArray());
		return seriesJson;
	}

	private JSONArray getXAxisJsonArray() {
		String[] monthsArray = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		return new JSONArray(Arrays.asList(monthsArray));
	}
}
