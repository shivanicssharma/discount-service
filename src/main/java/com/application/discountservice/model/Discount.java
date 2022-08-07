package com.application.discountservice.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;

@Entity
public class Discount {
	
	@Id
	private String code;
	private double percentage;
	private ItemDiscountType discountType;
	//three type of discounts
	//ITEM_TYPE
	private String itemType;
	//COUNT_OF_ITEMS
	private int itemId;
	private int itemCount;
	//TOTAL_COST
	private double minimumTotalAmount;

	
	public double getMinimumTotalAmount() {
		return minimumTotalAmount;
	}
	public void setMinimumTotalAmount(double minimumTotalAmount) {
		this.minimumTotalAmount = minimumTotalAmount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public ItemDiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(ItemDiscountType discountType) {
		this.discountType = discountType;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	@Override
	public String toString() {
		return "Discount [code=" + code + ", percentage=" + percentage + ", discountType=" + discountType
				+ ", itemType=" + itemType + ", itemId=" + itemId + ", itemCount=" + itemCount + ", minimumTotalAmount="
				+ minimumTotalAmount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, discountType, itemCount, itemId, itemType, minimumTotalAmount, percentage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		return Objects.equals(code, other.code) && discountType == other.discountType
				&& Objects.equals(itemCount, other.itemCount) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(itemType, other.itemType)
				&& Objects.equals(minimumTotalAmount, other.minimumTotalAmount) && percentage == other.percentage;
	}
	
	
}
