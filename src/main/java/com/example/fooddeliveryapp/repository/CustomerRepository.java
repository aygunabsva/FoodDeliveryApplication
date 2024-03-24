package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.dto.projection.CustomerProjection;
import com.example.fooddeliveryapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    CustomerProjection findByUserId(Long userId);

    @Query("SELECT p.id FROM Customer p WHERE p.user.username = :username")
    Long findUserIdByUsername(@Param("username") String username);

}
