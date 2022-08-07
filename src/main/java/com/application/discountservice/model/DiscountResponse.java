package com.application.discountservice.model;

public class DiscountResponse {
	
	private String code;
	private Double cost;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
}
