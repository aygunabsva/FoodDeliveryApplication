package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.enums.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByFoodCategory(FoodCategory foodCategory);

}
