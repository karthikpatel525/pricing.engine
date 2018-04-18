package com.pricing.engine.functions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.pricing.engine.constants.SellerRatioMapping;
import com.pricing.engine.constants.SupplyDemandEnum;

public class PriceEngineSimulator {

	private Table<String, SupplyDemandEnum, ProductSurvey> products = HashBasedTable.create();

	private class ProductSurvey {
		private double mostFrequentPrice;
		private int maxCount = 0;
		private double sumOfPrices = 0;
		private int totalSurveys = 0;
		HashMap<Double, Integer> pricesCount = new HashMap <>();

		public void addPrice(double costPrice) {
			pricesCount.putIfAbsent(costPrice, 0);
			if (totalSurveys > 0) {
				double avgPrice = sumOfPrices / totalSurveys;
				if (avgPrice * 2 < costPrice || avgPrice / 2 > costPrice) {
					return;
				}
			}
			int count = pricesCount.get(costPrice) + 1;
			pricesCount.put(costPrice, count);
			if (count > maxCount || (count == maxCount && costPrice < mostFrequentPrice)) {
				maxCount = count;
				mostFrequentPrice = costPrice;
			}
			totalSurveys++;
			sumOfPrices = sumOfPrices + costPrice;
		}

		public double getMostFrequentPrice() {
			return mostFrequentPrice;
		}
	}

	public void parseInput() {
		Scanner sc = new Scanner(System.in);
		int numOfProducts = Integer.parseInt(sc.nextLine());
		while (numOfProducts > 0) {
			String line = sc.nextLine();
			String split[] = line.split(" ");
			String product = split[0];
			String supply = split[1];
			String demand = split[2];
			products.put(product, SupplyDemandUtil.getSupplyDemandDivision(supply, demand), new ProductSurvey());
			numOfProducts--;
		}
		int surveys = Integer.parseInt(sc.nextLine());
		while (surveys > 0) {
			String line = sc.nextLine();
			String split[] = line.split(" ");
			String product = split[0];
			double costPrice = Double.parseDouble(split[2]);
			products.row(product).values().stream().findFirst().get().addPrice(costPrice);
			surveys--;
		}
		sc.close();
	}

	public Map<String, Double> getPriceRecommendations() {
		Map<String, Double> priceRecommendations = new HashMap<>();
		for (String product : products.rowKeySet()) {
			Map.Entry<SupplyDemandEnum, ProductSurvey> entry = products.row(product).entrySet().iterator().next();

			priceRecommendations.put(product,
					SellerRatioMapping.getSoldPrice(entry.getKey(), entry.getValue().getMostFrequentPrice()));
		}

		return priceRecommendations;
	}

}
