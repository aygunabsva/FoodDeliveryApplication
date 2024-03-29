package com.example.fooddeliveryapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderHistory;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Basket basket;
}
