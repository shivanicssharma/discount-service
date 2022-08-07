package com.application.discountservice.model;

import java.util.Objects;

public class Item {
	
	private int id;
	private double cost;
    private String itemType;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", cost=" + cost + ", itemType=" + itemType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cost, id, itemType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return cost == other.cost && id == other.id && Objects.equals(itemType, other.itemType);
	}
	
	
	
	
	
	
	

}
