package com.example.fooddeliveryapp.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MenuReqDTO {
    private String name;
    private Long restaurantId;
}
