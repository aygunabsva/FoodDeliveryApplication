package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO createRestaurant(RestaurantReqDTO restaurantReqDTO);

    void deleteRestaurant(Long restaurantId);

    List<RestaurantDTO> getAll();

    List<RestaurantDTO> showRestaurantByName(String name);

    List<ProductDTO> getProductsByRestaurantName(String restaurantName);
}
