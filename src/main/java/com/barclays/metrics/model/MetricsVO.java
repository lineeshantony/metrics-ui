package com.barclays.metrics.model;

public class MetricsVO {

	private int id;
	private String type;

	public MetricsVO(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

}
