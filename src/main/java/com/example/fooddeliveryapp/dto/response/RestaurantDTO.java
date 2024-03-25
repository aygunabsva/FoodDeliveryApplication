package com.example.fooddeliveryapp.dto.response;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private Double avgRating;
}

