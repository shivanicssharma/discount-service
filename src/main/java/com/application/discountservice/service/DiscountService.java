package com.application.discountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.discountservice.model.Discount;
import com.application.discountservice.model.DiscountFactory;
import com.application.discountservice.model.DiscountProcessor;
import com.application.discountservice.model.DiscountResponse;
import com.application.discountservice.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.application.discountservice.repository.DiscountRepository;

@Service
public class DiscountService {

	@Autowired
	private DiscountRepository discountRepository;
	
    Logger logger = LoggerFactory.getLogger(DiscountService.class);


	public Discount addDiscount(Discount discount) {

		return discountRepository.save(discount);

	}

	public void deleteDiscount(Discount discount) {
		discountRepository.delete(discount);
	}
	
     public List<Discount> getDiscounts() {
		
    	return discountRepository.findAll();
		
	}

	public DiscountResponse calculateBestDiscount(List<Item> items) {
		
		logger.info("Inside << calculateBestDiscount() method>>");


		DiscountResponse discountResponse = new DiscountResponse();

		List<Discount> discounts = discountRepository.findAll();

		double bestDiscount = 0;
		String bestDiscountCode = null;
		for (Discount discount : discounts) {

			double totalDiscount = calculateTotalDiscount(discount, items);

			if (totalDiscount > bestDiscount) {
				bestDiscount = totalDiscount;
				bestDiscountCode = discount.getCode();

			}

		}
		double totalItemsCost = items.stream().map(Item::getCost).reduce(0.0, Double::sum);

		discountResponse.setCost(totalItemsCost - bestDiscount);
		discountResponse.setCode(bestDiscountCode);

		return discountResponse;
	}

	private double calculateTotalDiscount(Discount discount, List<Item> items) {
		logger.info("Inside << calculateTotalDiscount() method>>");

		
		DiscountFactory discountFactory = new DiscountFactory();
		DiscountProcessor discountProcessor;
		
		discountProcessor =  discountFactory.getInstance(discount.getDiscountType());
		return discountProcessor.calculateDiscount(discount, items);
	}
		
}
