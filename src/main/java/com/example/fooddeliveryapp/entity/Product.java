package com.example.fooddeliveryapp.entity;

import com.example.fooddeliveryapp.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String pictureUrl;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
