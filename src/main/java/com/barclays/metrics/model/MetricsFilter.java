package com.barclays.metrics.model;

public class MetricsFilter {

	private String metricsType;
	private String transactionCycle;
	private String geography;
	private String project;
	private String repo;

	public String getTransactionCycle() {
		return transactionCycle;
	}

	public void setTransactionCycle(String transactionCycle) {
		this.transactionCycle = transactionCycle;
	}

	public String getGeography() {
		return geography;
	}

	public void setGeography(String geography) {
		this.geography = geography;
	}

	public String getMetricsType() {
		return metricsType;
	}

	public void setMetricsType(String metricsType) {
		this.metricsType = metricsType;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRepo() {
		return repo;
	}

	public void setRepo(String repo) {
		this.repo = repo;
	}

}
