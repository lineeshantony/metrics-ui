package com.barclays.metrics.web;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.metrics.charts.ChartCreator;

@RestController
public class ChartsRestController {

	@RequestMapping(value = "/getPieChartData/{componentName}/{selectedMetricType}", method = RequestMethod.GET)
	public String getPieChartData(@PathVariable(value = "componentName") String componentName,
			@PathVariable(value = "selectedMetricType") int selectedMetricType) throws JSONException {
		return new ChartCreator().getData(componentName, selectedMetricType).toString();
	}

}
