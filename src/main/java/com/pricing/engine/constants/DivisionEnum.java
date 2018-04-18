package com.pricing.engine.constants;

public enum DivisionEnum {
	HIGH("H", "High"), LOW("L", "Low");
	private String id;
	private String description;

	private DivisionEnum(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

}
