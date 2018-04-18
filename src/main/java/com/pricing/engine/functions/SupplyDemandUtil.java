package com.pricing.engine.functions;

import com.pricing.engine.constants.DivisionEnum;
import com.pricing.engine.constants.SupplyDemandEnum;

public class SupplyDemandUtil {

	public static SupplyDemandEnum getSupplyDemandDivision(String supply, String demand) {
		if (supply.equals(DivisionEnum.HIGH.getId())) {
			if (demand.equals(DivisionEnum.HIGH.getId())) {
				return SupplyDemandEnum.SUPPLY_HIGH_DEMAND_HIGH;
			} else if (demand.equals(DivisionEnum.LOW.getId())) {
				return SupplyDemandEnum.SUPPLY_HIGH_DEMAND_LOW;
			}
		} else {
			if (demand.equals(DivisionEnum.HIGH.getId())) {
				return SupplyDemandEnum.SUPPLY_LOW_DEMAND_HIGH;
			} else if (demand.equals(DivisionEnum.LOW.getId())) {
				return SupplyDemandEnum.SUPPLY_LOW_DEMAND_LOW;
			}
		}
		return null;
	}
}
