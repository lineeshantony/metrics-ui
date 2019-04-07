package com.barclays.metrics.model;

public class SegmentVO {
	private String segmentKey;
	private String segmentName;

	public SegmentVO(String segmentKey, String segmentName) {
		this.segmentKey = segmentKey;
		this.segmentName = segmentName;
	}

	public String getSegmentKey() {
		return segmentKey;
	}

	public String getSegmentName() {
		return segmentName;
	}

}
