package com.barclays.metrics.charts;

import java.util.List;

public class PieceOfTrend {

	private String name;
	private List<Integer> trendValues;
	
	public PieceOfTrend(String name, List<Integer> trendValues) {
		this.name = name;
		this.trendValues = trendValues;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getTrendValues() {
		return trendValues;
	}

}
