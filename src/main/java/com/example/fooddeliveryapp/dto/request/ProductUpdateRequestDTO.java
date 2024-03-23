package com.example.fooddeliveryapp.dto.request;

import com.example.fooddeliveryapp.enums.FoodCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ProductUpdateRequestDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String pictureUrl;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;}
