package com.barclays.metrics.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barclays.metrics.charts.ChartCreator;
import com.barclays.metrics.data.SegmentDataCollector;
import com.barclays.metrics.model.MetricsFilter;
import com.barclays.metrics.model.MetricsVO;
import com.barclays.metrics.model.SegmentVO;
import com.google.gson.Gson;

@Controller
public class ChartsController {

	private MetricsFilter metricsFilter = new MetricsFilter();

	@Autowired
	private SegmentDataCollector segmentDataCollector;

	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model) throws JSONException, ClientProtocolException, IOException {
		metricsFilter.setMetricsType("build-duration");
		metricsFilter.setTransactionCycle("all");
		model.addAttribute("chartData", new ChartCreator().getData(metricsFilter).toString());
		model.addAttribute("metricsFilter", metricsFilter);
		model.addAttribute("segmentMap", new Gson().toJson(segmentDataCollector.getOrCreateSegmentMap()));

		List<Integer> clCodecoverage = Arrays.asList(4074, 3455, 4112);
		List<Integer> bapiCodecoverage = Arrays.asList(3222, 3011, 3788);
		List<Integer> cardNGCodecoverage = Arrays.asList(7811, 7098, 6455);

		model.addAttribute("CardNG", cardNGCodecoverage);
		model.addAttribute("BAPI", bapiCodecoverage);
		model.addAttribute("CL", clCodecoverage);

		return "chart";
	}

	@PostMapping("/metricsFilter")
	public String metricsFilterSubmit(Model model, @ModelAttribute MetricsFilter metricsFilter) throws JSONException, ClientProtocolException, IOException {
		this.metricsFilter = metricsFilter;
		System.out.println(metricsFilter);
		model.addAttribute("chartData",
				new ChartCreator().getData(metricsFilter).toString());
		model.addAttribute("metricsFilter", metricsFilter);
		model.addAttribute("segmentMap", new Gson().toJson(segmentDataCollector.getOrCreateSegmentMap()));
		return "chart";
	}

	@ModelAttribute("metricTypes")
	public List<MetricsVO> populateMetricTypes() {
		ArrayList<MetricsVO> metricTypes = new ArrayList<MetricsVO>();
		metricTypes.add(new MetricsVO("build-duration", "Build Time"));
		metricTypes.add(new MetricsVO("commit-frequency", "Commit Frequency"));
		metricTypes.add(new MetricsVO("commit-frequency-trend-comparison", "Commit Frequency Trend Comparison"));
		return metricTypes;
	}

	@ModelAttribute("tcSegments")
	public List<SegmentVO> populateBusinessUnits() {
		return segmentDataCollector.getOrCreateSegmentMap().get("org");
	}

}
