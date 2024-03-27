package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantRatingDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface RatingService {
    RatingDTO add(HttpServletRequest request, RatingReqDTO ratingReqDTO);

    RestaurantRatingDTO getRestaurantRatingByName(String restaurantName);

}
