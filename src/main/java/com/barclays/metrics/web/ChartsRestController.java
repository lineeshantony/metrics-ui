package com.barclays.metrics.web;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.metrics.charts.ChartCreator;
import com.barclays.metrics.model.MetricsFilter;

@RestController
public class ChartsRestController {

	@RequestMapping(value = "/getPieChartData/{selectedMetricType}/{transactionCycle}/{geography}/{project}/{repo}", method = RequestMethod.GET)
	public String getPieChartData(@PathVariable(value = "selectedMetricType") String selectedMetricType,
			@PathVariable(value = "transactionCycle") String transactionCycle,
			@PathVariable(value = "geography") String geography, @PathVariable(value = "project") String project,
			@PathVariable(value = "repo") String repo) throws JSONException, ClientProtocolException, IOException {
		MetricsFilter metricsFilter = new MetricsFilter();
		metricsFilter.setMetricsType(selectedMetricType);
		metricsFilter.setTransactionCycle(transactionCycle);
		metricsFilter.setGeography(geography);
		metricsFilter.setProject(project);
		metricsFilter.setRepo(repo);

		return new ChartCreator().getData(metricsFilter).toString();
	}

}
