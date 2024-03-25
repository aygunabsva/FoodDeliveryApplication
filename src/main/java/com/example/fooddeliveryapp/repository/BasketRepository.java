package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
