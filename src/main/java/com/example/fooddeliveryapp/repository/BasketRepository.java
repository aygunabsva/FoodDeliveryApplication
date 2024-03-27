package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.entity.Basket;
import com.example.fooddeliveryapp.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findByCustomerId(Long id);

    List<Basket> findByCustomerIdAndProductStatus(Long customerId, ProductStatus productStatus);

}
