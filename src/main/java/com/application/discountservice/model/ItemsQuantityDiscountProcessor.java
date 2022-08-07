package com.application.discountservice.model;

import java.util.List;

public class ItemsQuantityDiscountProcessor implements DiscountProcessor{

	@Override
	public double calculateDiscount(Discount discount, List<Item> items) {
		long itemCount = items.stream().filter(item -> discount.getItemId() == item.getId()).count();

		double sum = items.stream().filter(item -> discount.getItemId() == item.getId()).map(Item::getCost).reduce(0.0,
				Double::sum);

		if (itemCount > discount.getItemCount()) {
			return applyDiscount(sum, discount.getPercentage());
		} else {
			return 0;
		}
	}
}
