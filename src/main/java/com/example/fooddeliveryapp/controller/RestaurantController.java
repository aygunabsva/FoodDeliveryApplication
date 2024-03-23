package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.RestaurantDeleteRequestDTO;
import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantReqDTO restaurantReqDTO) {
        RestaurantDTO createdRestaurant = restaurantService.createRestaurant(restaurantReqDTO);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRestaurant(@RequestBody RestaurantDeleteRequestDTO requestDTO) {
        restaurantService.deleteRestaurant(requestDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
