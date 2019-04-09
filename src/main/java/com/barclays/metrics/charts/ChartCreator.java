package com.barclays.metrics.charts;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.barclays.metrics.model.MetricsFilter;
import com.barclays.metrics.web.APIInvoker;

public class ChartCreator {

	@Autowired
	private APIInvoker apiInvoker;

	public JSONObject getData(MetricsFilter metricsFilter) throws JSONException, ClientProtocolException, IOException {
		String apiURL = "http://localhost:7005/metrices/" + metricsFilter.getMetricsType() + "/org";

		if (!"all".equals(metricsFilter.getTransactionCycle())) {
			apiURL += "/" + metricsFilter.getTransactionCycle();
			if (!"all".equals(metricsFilter.getGeography())) {
				apiURL += "/" + metricsFilter.getGeography();
				if (!"all".equals(metricsFilter.getProject())) {
					apiURL += "/" + metricsFilter.getProject();
					if (!"all".equals(metricsFilter.getRepo())) {
						apiURL += "/" + metricsFilter.getRepo();
					}
				}
			}
		}
		apiURL += "?fromDate=2019-01-01&toDate=2019-05-01";
		System.out.println("apiURL: " + apiURL);
		String responseData = new APIInvoker().callAPI(apiURL);
		if ("build-duration".equals(metricsFilter.getMetricsType())
				|| "commit-frequency".equals(metricsFilter.getMetricsType())) {
			PieChartCreator pieChartCreator = new PieChartCreator(responseData);
			return pieChartCreator.getData();
		} else if ("commit-frequency-trend-comparison".equals(metricsFilter.getMetricsType())) {
			TrendComparisonChartCreator commitFrequencyTrendPieChartCreator = new TrendComparisonChartCreator(
					responseData);
			return commitFrequencyTrendPieChartCreator.getData();
		}
		return new JSONObject();
	}
}
