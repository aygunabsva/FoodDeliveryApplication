package com.example.fooddeliveryapp.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RatingDTO {
    private Long id;
    private Long customerId;
    private Long restaurantId;
    private Integer ratingValue;
    private String comment;
    private String timestamp;
}
