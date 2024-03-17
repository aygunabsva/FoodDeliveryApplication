package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
