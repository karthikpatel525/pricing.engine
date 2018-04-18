package com.pricing.engine.constants;

public class SellerRatioMapping {

	public static double getSoldPrice(SupplyDemandEnum supplyDemand, double costPrice) {

		switch (supplyDemand) {
		case SUPPLY_HIGH_DEMAND_HIGH:
			return costPrice;
		case SUPPLY_LOW_DEMAND_LOW:
			return costPrice + (0.1 * costPrice);
		case SUPPLY_LOW_DEMAND_HIGH:
			return costPrice + (0.05 * costPrice);
		case SUPPLY_HIGH_DEMAND_LOW:
			return costPrice - (0.05 * costPrice);
		default:
			return costPrice;
		}
	}
}
