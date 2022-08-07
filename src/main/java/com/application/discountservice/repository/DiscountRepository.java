package com.application.discountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.discountservice.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {

}
