package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.CommentsDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantRatingDTO;
import com.example.fooddeliveryapp.entity.Menu;
import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.entity.Rating;
import com.example.fooddeliveryapp.entity.Restaurant;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.mapper.ProductMapper;
import com.example.fooddeliveryapp.mapper.RatingMapper;
import com.example.fooddeliveryapp.mapper.RestaurantMapper;
import com.example.fooddeliveryapp.repository.RatingRepository;
import com.example.fooddeliveryapp.repository.RestaurantRepository;
import com.example.fooddeliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RatingRepository ratingRepository;
    private final RestaurantMapper restaurantMapper;
    private final ProductMapper productMapper;

    @Override
    public RestaurantDTO add(RestaurantReqDTO restaurantReqDTO) {
        log.info("Restaurant add method started");
        Restaurant restaurant = restaurantMapper.toEntity(restaurantReqDTO);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        RestaurantDTO restaurantDTO = restaurantMapper.toDTO(savedRestaurant);
        log.info("Created a new restaurant: {}", restaurantReqDTO.getName());
        return restaurantDTO;
    }

    @Override
    public void delete(Long restaurantId) {
        log.info("Restaurant delete method started");
        restaurantRepository.deleteById(restaurantId);
        log.info("Deleted a restaurant with the ID: {}", restaurantId);
    }

    @Override
    public List<RestaurantDTO> getAll() {
        log.info("Restaurant getAll method started");
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.isEmpty()) {
            throw new NotFoundException("Restaurant not found");
        }
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            RestaurantDTO restaurantDTO = restaurantMapper.toDTO(restaurant);
            Double avgRating = ratingRepository.findAverageRatingByRestaurantId(restaurant.getId());
            restaurantDTO.setAvgRating(avgRating);
            restaurantDTOS.add(restaurantDTO);
        }
        log.info("Found {} restaurants", restaurantDTOS.size());
        return restaurantDTOS;
    }

    @Override
    public RestaurantDTO getByName(String name) {
        log.info("Read restaurant by name method started");

        Restaurant restaurant = restaurantRepository.findRestaurantByNameIgnoreCase(name);
        if (restaurant.getName().isEmpty()) {
            throw new NotFoundException("Restaurant in this name not found");
        }
        RestaurantDTO restaurantDTO = restaurantMapper.toDTO(restaurant);
        restaurantDTO.setAvgRating(ratingRepository.findAverageRatingByRestaurantId(restaurant.getId()));
        log.info("Found restaurants with a name {}", name);
        return restaurantDTO;
    }


    @Override
    public List<ProductDTO> getProductsByName(String restaurantName) {
        log.info("Read products by restaurant method started");
        Restaurant restaurant = restaurantRepository.findByNameIgnoreCase(restaurantName)
                .orElseThrow(() -> new NotFoundException("Restaurant not found with name: " + restaurantName));

        Menu menu = restaurant.getMenu();
        if (menu == null) {
            throw new NotFoundException("Menu not found for restaurant: " + restaurantName);
        }
        List<Product> products = menu.getProducts();
        List<ProductDTO> productDTOS = products.stream()
                .map(productMapper::toDTO)
                .toList();
        log.info("Found {} products in {} restaurant", products.size(), restaurantName);
        return productDTOS;
    }



}
