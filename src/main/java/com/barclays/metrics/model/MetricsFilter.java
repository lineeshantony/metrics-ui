package com.barclays.metrics.model;

public class MetricsFilter {

	private int metricsType;
	private int businessUnit;

	public int getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(int businessUnit) {
		this.businessUnit = businessUnit;
	}

	public int getMetricsType() {
		return metricsType;
	}

	public void setMetricsType(int metricsType) {
		this.metricsType = metricsType;
	}

}
