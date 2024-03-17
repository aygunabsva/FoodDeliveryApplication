package com.example.fooddeliveryapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "restaurants", fetch = FetchType.LAZY)
    private List<Rating> ratingList;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Menu menu;
}
