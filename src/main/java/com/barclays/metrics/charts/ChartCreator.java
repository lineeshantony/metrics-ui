package com.barclays.metrics.charts;

import org.json.JSONException;
import org.json.JSONObject;

import com.barclays.metrics.model.MetricsFilter;

public class ChartCreator {
	public JSONObject getData(MetricsFilter metricsFilter) throws JSONException {
		if ("build-duration".equals(metricsFilter.getMetricsType())) {
			BuildTimePieChartCreator buildTimePieChartCreator = new BuildTimePieChartCreator();
			return buildTimePieChartCreator.getData(metricsFilter.getTransactionCycle());
		} else if ("commit-frequency".equals(metricsFilter.getMetricsType())) {
			CommitFrequencyPieChartCreator commitFrequencyPieChartCreator = new CommitFrequencyPieChartCreator();
			return commitFrequencyPieChartCreator.getData(metricsFilter.getTransactionCycle());
		} else if ("commit-frequency-trend-comparison".equals(metricsFilter.getMetricsType())) {
			CommitFrequencyTrendComparisonChartCreator commitFrequencyTrendPieChartCreator = new CommitFrequencyTrendComparisonChartCreator();
			return commitFrequencyTrendPieChartCreator.getData(metricsFilter.getTransactionCycle());
		}
		return new JSONObject();
	}
}
