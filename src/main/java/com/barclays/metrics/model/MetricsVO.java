package com.barclays.metrics.model;

public class MetricsVO {

	private String key;
	private String type;

	public MetricsVO(String key, String type) {
		this.key = key;
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public String getType() {
		return type;
	}

}
