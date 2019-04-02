package com.barclays.metrics.web;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barclays.metrics.charts.PieChartCreator;

@Controller
public class ChartsController {

	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model) throws JSONException {
		model.addAttribute("pieData", new PieChartCreator().getPieData("all").toString());
		
		List<Integer> clCodecoverage = Arrays.asList(4074, 3455, 4112);
		List<Integer> bapiCodecoverage = Arrays.asList(3222, 3011, 3788);
		List<Integer> cardNGCodecoverage = Arrays.asList(7811, 7098, 6455);

		model.addAttribute("CardNG", cardNGCodecoverage);
		model.addAttribute("BAPI", bapiCodecoverage);
		model.addAttribute("CL", clCodecoverage);

		return "chart";
	}
	
}
