package com.application.discountservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.discountservice.controller.DiscountController;
import com.application.discountservice.model.Discount;
import com.application.discountservice.model.DiscountResponse;
import com.application.discountservice.model.Item;
import com.application.discountservice.model.ItemDiscountType;
import com.application.discountservice.repository.DiscountRepository;

@SpringBootTest
public class DiscountControllerTest {
	
	@Autowired
	DiscountRepository repo;
	
	@Autowired
	DiscountController discountController;
	
	  @BeforeEach
	    public void setUp(){
		  repo.deleteAll();
	       
	    }
	
	@Test
	public void test1CalculateBestDiscount() {
		
		 discountController.addDiscount(addFirstDiscount());
	
		 discountController.addDiscount(addSecondDiscount());
		 DiscountResponse discountResponse =discountController.calculateBestDiscount(addItemsForTwoDiscounts());
		 
		Assertions.assertEquals("ABC" , discountResponse.getCode());
		Assertions.assertEquals(45 , discountResponse.getCost());

		
	}
	 @Test
	 public void test2CalculateBestDiscount() {
		
		 discountController.addDiscount(addFirstDiscount());
		 discountController.addDiscount(addSecondDiscount());
		 discountController.addDiscount(addThirdDiscount());
		 
		 DiscountResponse discountResponse =discountController.calculateBestDiscount(addItemsForThreeDiscounts());
		
		 Assertions.assertEquals("FGH" , discountResponse.getCode());
		 Assertions.assertEquals(200 , discountResponse.getCost());
	}
	 
	 @Test
	 public void test3CalculateBestDiscount() {
		
		 discountController.addDiscount(addFirstDiscount());
		 discountController.addDiscount(addSecondDiscount());
		 
		 DiscountResponse discountResponse =discountController.calculateBestDiscount(addTwoDifferentItems());
		 
		 System.out.println(discountResponse.getCode());
		 System.out.println(discountResponse.getCost());

		
		 Assertions.assertEquals("CDE" , discountResponse.getCode());
		 Assertions.assertEquals(305 , discountResponse.getCost());
	}

	 


	private List<Item> addTwoDifferentItems() {
		List<Item>  items = new ArrayList<>();
		Item item1 = new Item();
		item1.setCost(50);
		item1.setId(123);
		item1.setItemType("CLOTHES");
		Item item2 = new Item();
		item2.setCost(300);
		item2.setId(456);
		item2.setItemType("ELECTRONICS");
		items.add(item1);

		items.add(item2);
		return items;
	}

	private List<Item> addItemsForThreeDiscounts() {
		List<Item>  items = new ArrayList<>();
		Item item = new Item();
		item.setCost(50);
		item.setId(123);
		item.setItemType("CLOTHES");
		items.add(item);
		items.add(item);
		items.add(item);
		items.add(item);
		items.add(item);
		
		return items;
	}

	private List<Item> addItemsForTwoDiscounts() {
		List<Item>  items = new ArrayList<>();
		Item item = new Item();
		item.setCost(50);
		item.setId(123);
		item.setItemType("CLOTHES");
		items.add(item);
		
		return items;
	}


	private Discount addFirstDiscount() {
		
		 Discount discount = new Discount();
		 discount.setCode("ABC");
		 discount.setPercentage(10);
		 discount.setDiscountType(ItemDiscountType.ITEM_TYPE);
		 discount.setItemId(123);
		 discount.setItemType("CLOTHES");
		return discount;
		}
	private Discount addSecondDiscount() {
	
		 Discount discount = new Discount();
		 discount.setCode("CDE");
		 discount.setPercentage(15);
		 discount.setItemId(123);
		 discount.setMinimumTotalAmount(100);
		 discount.setDiscountType(ItemDiscountType.TOTAL_COST);
		 return discount;
		}
	
	private Discount addThirdDiscount() {
		
		 Discount discount = new Discount();
		 discount.setCode("FGH");
		 discount.setPercentage(20);
		 discount.setDiscountType(ItemDiscountType.COUNT_OF_ITEMS);
		 discount.setItemId(123);
		 discount.setMinimumTotalAmount(3);
		return discount;
		}
}
