package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
