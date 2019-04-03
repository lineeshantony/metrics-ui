package com.barclays.metrics.charts;

import org.json.JSONException;
import org.json.JSONObject;

public class ChartCreator {
	public JSONObject getData(String projectName, int metricsType) throws JSONException {
		if (metricsType == 1) {
			BuildTimePieChartCreator buildTimePieChartCreator = new BuildTimePieChartCreator();
			return buildTimePieChartCreator.getPieData(projectName);
		} else if (metricsType == 2) {
			CommitFrequencyPieChartCreator commitFrequencyPieChartCreator = new CommitFrequencyPieChartCreator();
			return commitFrequencyPieChartCreator.getPieData(projectName);
		}
		return null;
	}
}
