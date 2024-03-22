package com.example.fooddeliveryapp.dto.response;

import lombok.Data;

@Data
public class MenuDTO {
    private Long id;
    private String name;
    private Long restaurantId;
}
