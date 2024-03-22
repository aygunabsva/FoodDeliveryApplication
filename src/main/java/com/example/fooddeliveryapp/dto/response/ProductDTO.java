package com.example.fooddeliveryapp.dto.response;

import com.example.fooddeliveryapp.enums.FoodCategory;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String pictureUrl;
    private Long menuId;
    private FoodCategory foodCategory;
}
