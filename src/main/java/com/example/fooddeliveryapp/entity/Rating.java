package com.example.fooddeliveryapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurants;

    @Max(5)
    private Integer ratingValue;
    private String comment;
    private LocalDateTime timestamp;
}
