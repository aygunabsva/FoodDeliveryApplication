package com.example.fooddeliveryapp.dto.request;

import com.example.fooddeliveryapp.enums.FoodCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ProductReqDTO {
    private String name;
    private Double price;
    private String description;
    private String pictureUrl;
    private Long menuId;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;
}
