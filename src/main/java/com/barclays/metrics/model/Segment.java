package com.barclays.metrics.model;

public enum Segment {
	ALL(1, "All"), 
	CARDS(2, "Cards"), 
	FRAUD(3, "Fraud"), 
	CARDS_USA(4, "Cards USA"), 
	CARDS_UK(5, "Cards UK"), 
	CARDS_GERMANY(6, "Cards Germany"), 
	FRAUD_USA(7, "Fraud USA"), 
	FRAUD_UK(8, "Fraud UK"), 
	FRAUD_GERMANY(9, "Fraud Germany"), 
	CARDNG(10, "CardNG"), 
	BAPI(11, "BAPI");

	private int value;
	private String name;

	Segment(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
