package com.application.discountservice.model;

import java.util.List;

public class ItemTypeDiscountProcessor implements DiscountProcessor{

	@Override
	public double calculateDiscount(Discount discount, List<Item> items) {
		double totalEligibleAmount = items.stream().filter(item -> item.getItemType().equals(discount.getItemType()))
				.map(item -> item.getCost()).reduce(0.0, Double::sum);
		return applyDiscount(totalEligibleAmount, discount.getPercentage());
	}

}
