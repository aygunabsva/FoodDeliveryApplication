package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.RestaurantDeleteRequestDTO;
import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantRatingDTO;
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

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO add(@RequestBody RestaurantReqDTO restaurantReqDTO) {
        return restaurantService.add(restaurantReqDTO);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantDTO> getAll() {
        return restaurantService.getAll();
    }
    @GetMapping("/{restaurantName}/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProductsByName(@PathVariable String restaurantName) {
        return restaurantService.getProductsByName(restaurantName);
    }
    @GetMapping("/{restaurantName}/ratings")
    public ResponseEntity<RestaurantRatingDTO> getRestaurantRatings(@PathVariable String restaurantName) {
        RestaurantRatingDTO restaurantRatingDTO = restaurantService.getRestaurantRatingByName(restaurantName);
        return new ResponseEntity<>(restaurantRatingDTO, HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantDTO getByName(@PathVariable String name) {
        return restaurantService.getByName(name);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Void delete(@RequestBody RestaurantDeleteRequestDTO requestDTO) {
        restaurantService.delete(requestDTO.getId());
        return null;
    }
}
