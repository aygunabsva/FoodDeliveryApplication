package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantRatingDTO;

import java.util.List;

public interface RestaurantService {
    RestaurantDTO add(RestaurantReqDTO restaurantReqDTO);

    void delete(Long restaurantId);

    List<RestaurantDTO> getAll();

    RestaurantDTO getByName(String name);

    List<ProductDTO> getProductsByName(String restaurantName);

}
