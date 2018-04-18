package com.pricing.engine.constants;

public enum SupplyDemandEnum {

	SUPPLY_HIGH_DEMAND_HIGH(1, "Supply is High and Demand is High"), SUPPLY_LOW_DEMAND_LOW(2,
			"Supply is Low and Demand is Low"), SUPPLY_LOW_DEMAND_HIGH(3,
					"Supply is Low and Demand is High"), SUPPLY_HIGH_DEMAND_LOW(4, "Supply is High and Demand is Low");

	private int id;
	private String description;

	private SupplyDemandEnum(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}
