package com.barclays.metrics.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barclays.metrics.charts.ChartCreator;
import com.barclays.metrics.model.MetricsFilter;
import com.barclays.metrics.model.MetricsVO;
import com.barclays.metrics.model.Segment;

@Controller
public class ChartsController {
	
	MetricsFilter metricsFilter = new MetricsFilter();

	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String chart(Model model) throws JSONException {
		model.addAttribute("chartData", new ChartCreator().getData("All", 1).toString());
		model.addAttribute("metricsFilter", metricsFilter);
		List<Integer> clCodecoverage = Arrays.asList(4074, 3455, 4112);
		List<Integer> bapiCodecoverage = Arrays.asList(3222, 3011, 3788);
		List<Integer> cardNGCodecoverage = Arrays.asList(7811, 7098, 6455);

		model.addAttribute("CardNG", cardNGCodecoverage);
		model.addAttribute("BAPI", bapiCodecoverage);
		model.addAttribute("CL", clCodecoverage);

		return "chart";
	}
	
    @PostMapping("/metricsFilter")
    public String metricsFilterSubmit(Model model, @ModelAttribute MetricsFilter metricsFilter) throws JSONException {
    	this.metricsFilter = metricsFilter;
    	model.addAttribute("chartData", 
    			new ChartCreator().getData(getSegmentName(metricsFilter), metricsFilter.getMetricsType()).toString());
		model.addAttribute("metricsFilter", metricsFilter);
        return "chart";
    }

	private String getSegmentName(MetricsFilter metricsFilter) {
		return ChartsController.fromInt(metricsFilter.getBusinessUnit()).getName();
	}
    
    @ModelAttribute("metricTypes")
    public List<MetricsVO> populateMetricTypes()
    {
        ArrayList<MetricsVO> metricTypes = new ArrayList<MetricsVO>();
        metricTypes.add(new MetricsVO(1,  "Build Time"));
        metricTypes.add(new MetricsVO(2,  "Commit Frequency"));
        metricTypes.add(new MetricsVO(3,  "Commit Frequency Trend"));
        return metricTypes;
    }
    
    @ModelAttribute("allSegments")
    public List<Segment> populateBusinessUnits()
    {
        ArrayList<Segment> segments = new ArrayList<Segment>();
        segments.add(Segment.ALL);
        segments.add(Segment.CARDS);
        segments.add(Segment.FRAUD);
        segments.add(Segment.CARDS_USA);
        segments.add(Segment.CARDS_UK);
        segments.add(Segment.CARDS_GERMANY);
        segments.add(Segment.FRAUD_USA);
        segments.add(Segment.FRAUD_UK);
        segments.add(Segment.FRAUD_GERMANY);
        segments.add(Segment.CARDNG);
        segments.add(Segment.BAPI);
        return segments;
    }
    
    private static final Map<Integer, Segment> intToTypeMap = new HashMap<Integer, Segment>();
    static {
        for (Segment type : Segment.values()) {
            intToTypeMap.put(type.getValue(), type);
        }
    }

    public static Segment fromInt(int i) {
    	Segment type = intToTypeMap.get(Integer.valueOf(i));
        if (type == null) 
            return Segment.ALL;
        return type;
    }
}
