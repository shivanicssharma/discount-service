package com.application.discountservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.discountservice.model.Discount;
import com.application.discountservice.model.DiscountResponse;
import com.application.discountservice.model.Item;
import com.application.discountservice.service.DiscountService;

@RestController
public class DiscountController {
	
	
	@Autowired
	private DiscountService discountService;
	
	 
	 @PostMapping("/discount")
	 public Discount addDiscount(@RequestBody Discount discount) {
		 
		 return discountService.addDiscount(discount);
		 
	 }
	 
	 @DeleteMapping("/discount")
	 public void deleteDiscount(@RequestBody Discount discount) {
		 
		  discountService.deleteDiscount(discount);
		 
	 }
	 @GetMapping("/discount")
	 public List<Discount> getDiscounts() {
		 
		 return discountService.getDiscounts();
		 
	 }
	 
	 @PostMapping("/bestdiscount")
	 public @ResponseBody DiscountResponse calculateBestDiscount(@RequestBody List<Item> items) {
		 
		 return discountService.calculateBestDiscount(items);
		 
	 }

}
