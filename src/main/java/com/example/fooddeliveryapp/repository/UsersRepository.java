package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
