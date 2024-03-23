package com.example.fooddeliveryapp.dto.request;

import lombok.Data;

@Data
public class MenuUpdateRequestDTO {
    private Long id;
    private String newName;
    private Long restaurantId;
}
