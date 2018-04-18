package com.pricing.engine.functions;

import java.util.Map;

public class PriceEngine {

	public static void main(String argv[]) {
		PriceEngineSimulator psim = new PriceEngineSimulator();
		psim.parseInput();

		Map<String, Double> priceRecommendations = psim.getPriceRecommendations();
		for (String product : priceRecommendations.keySet()) {
			System.out.println("Product: " + product + " Price: " + priceRecommendations.get(product));
		}
	}
}
