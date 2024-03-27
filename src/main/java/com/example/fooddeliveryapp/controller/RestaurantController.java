package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantDTO getByName(@PathVariable String name) {
        return restaurantService.getByName(name);
    }

    @DeleteMapping("/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Void delete(@PathVariable Long restaurantId) {
        restaurantService.delete(restaurantId);
        return null;
    }
}
