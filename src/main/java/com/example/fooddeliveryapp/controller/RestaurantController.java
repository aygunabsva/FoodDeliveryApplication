package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.RestaurantDeleteRequestDTO;
import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<RestaurantDTO>> readAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantService.getAll();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    @GetMapping("/{restaurantName}/products")
    public ResponseEntity<List<ProductDTO>> getProductsByRestaurantName(@PathVariable String restaurantName) {
        List<ProductDTO> products = restaurantService.getProductsByRestaurantName(restaurantName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<RestaurantDTO>> showRestaurantByName(@PathVariable String name) {
        List<RestaurantDTO> restaurants = restaurantService.showRestaurantByName(name);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteRestaurant(@RequestBody RestaurantDeleteRequestDTO requestDTO) {
        restaurantService.deleteRestaurant(requestDTO.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
