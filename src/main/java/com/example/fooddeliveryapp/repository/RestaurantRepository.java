package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameIgnoreCase(String name);

    Restaurant findRestaurantByNameIgnoreCase(String name);

    Restaurant findRestaurantByCustomerId(Long id);



}
