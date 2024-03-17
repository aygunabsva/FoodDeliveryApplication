package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
