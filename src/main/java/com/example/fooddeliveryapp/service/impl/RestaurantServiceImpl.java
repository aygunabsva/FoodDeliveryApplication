package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.RestaurantReqDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.entity.Restaurant;
import com.example.fooddeliveryapp.mapper.RestaurantMapper;
import com.example.fooddeliveryapp.repository.RestaurantRepository;
import com.example.fooddeliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public RestaurantDTO createRestaurant(RestaurantReqDTO restaurantReqDTO) {
        log.info("restaurant add method started");
        Restaurant restaurant = restaurantMapper.toEntity(restaurantReqDTO);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        RestaurantDTO restaurantDTO = restaurantMapper.toDTO(savedRestaurant);
        log.info("restaurant add method finished");
        return restaurantDTO;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        log.info("restaurant delete method started");
        restaurantRepository.deleteById(restaurantId);
        log.info("restaurant delete method finished");
    }
}
