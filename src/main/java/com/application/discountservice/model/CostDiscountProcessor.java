package com.application.discountservice.model;

import java.util.List;

public class CostDiscountProcessor implements DiscountProcessor {

	@Override
	public double calculateDiscount(Discount discount, List<Item> items) {
		double totalCost = items.stream().filter(item -> item.getCost() > discount.getMinimumTotalAmount())
				.map(Item::getCost).reduce(0.0, Double::sum);

		return applyDiscount(totalCost, discount.getPercentage());

	}
}
