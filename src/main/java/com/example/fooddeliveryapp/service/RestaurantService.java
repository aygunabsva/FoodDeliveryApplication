package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;

public interface RestaurantService {
    RestaurantDTO createRestaurant(RestaurantReqDTO restaurantReqDTO);

    void deleteRestaurant(Long restaurantId);
}
