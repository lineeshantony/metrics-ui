package com.barclays.metrics.web;

import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.metrics.charts.PieChartCreator;

@RestController
public class ChartsRestController {

	 @RequestMapping(value = "/getPieChartData/{componentName}", method = RequestMethod.GET)
		public String getPieChartData(@PathVariable(value = "componentName") String componentName) throws JSONException {
			return new PieChartCreator().getPieData(componentName).toString();
		}

}
