package com.example.fooddeliveryapp.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantRatingDTO {
    private String restaurantName;
    private Double averageRating;
    private List<CommentsDTO> ratings;
}
