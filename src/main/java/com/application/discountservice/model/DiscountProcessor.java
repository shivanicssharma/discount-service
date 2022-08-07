package com.application.discountservice.model;

import java.util.List;

public interface DiscountProcessor {
	
	double calculateDiscount(Discount discount, List<Item> items);
	
	public default double applyDiscount(double totalEligibleAmount, double percentage) {
		return (totalEligibleAmount * percentage) / 100;

	} 

}
