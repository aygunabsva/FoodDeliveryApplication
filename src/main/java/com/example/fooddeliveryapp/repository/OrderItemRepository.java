package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<Basket, Long> {
}
