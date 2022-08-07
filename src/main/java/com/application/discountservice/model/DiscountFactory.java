package com.application.discountservice.model;

public class DiscountFactory {
	public DiscountProcessor getInstance(ItemDiscountType type) {
		if(type.equals(ItemDiscountType.COUNT_OF_ITEMS)) {
			return new ItemsQuantityDiscountProcessor();
		}else if(type.equals(ItemDiscountType.ITEM_TYPE)) {
			return new ItemTypeDiscountProcessor();
		}else {
			return new CostDiscountProcessor();
		}
	}
}
