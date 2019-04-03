package com.barclays.metrics.web;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barclays.metrics.charts.PieChartCreator;
import com.barclays.metrics.model.MetricsFilter;

@Controller
public class ChartsController {

	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model) throws JSONException {
		model.addAttribute("pieData", new PieChartCreator().getPieData("all").toString());
		 model.addAttribute("metricsFilter", new MetricsFilter());
		List<Integer> clCodecoverage = Arrays.asList(4074, 3455, 4112);
		List<Integer> bapiCodecoverage = Arrays.asList(3222, 3011, 3788);
		List<Integer> cardNGCodecoverage = Arrays.asList(7811, 7098, 6455);

		model.addAttribute("CardNG", cardNGCodecoverage);
		model.addAttribute("BAPI", bapiCodecoverage);
		model.addAttribute("CL", clCodecoverage);

		return "chart";
	}
	
	@GetMapping("/metricsFilter")
    public String metricsFilterForm(Model model) {
        model.addAttribute("metricsFilter", new MetricsFilter());
        return "metricsFilter";
    }

    @PostMapping("/metricsFilter")
    public String greetingSubmit(@ModelAttribute MetricsFilter greeting) {
        return "metricsFilter";
    }
}
