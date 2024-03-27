package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.CommentsDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantRatingDTO;
import com.example.fooddeliveryapp.entity.Rating;
import com.example.fooddeliveryapp.entity.Restaurant;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.mapper.RatingMapper;
import com.example.fooddeliveryapp.repository.CustomerRepository;
import com.example.fooddeliveryapp.repository.RatingRepository;
import com.example.fooddeliveryapp.repository.RestaurantRepository;
import com.example.fooddeliveryapp.service.RatingService;
import com.example.fooddeliveryapp.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final RatingMapper ratingMapper;
    private final JwtUtil jwtUtil;

    @Override
    public RatingDTO add(HttpServletRequest request, RatingReqDTO ratingReqDTO) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));

        /*
         after adding order table, add code for checking if rating user has any order from rated restaurant
        */

        log.info("Rating add method started by userId: {}", userId);
        Long customerId = customerRepository.findByUserId(Long.valueOf(userId)).getId();
        ratingReqDTO.setCustomerId(customerId);
        ratingReqDTO.setTimestamp(LocalDateTime.now());
        Rating rating = ratingMapper.toEntity(ratingReqDTO);
        Rating savedRating = ratingRepository.save(rating);
        RatingDTO ratingDTO = ratingMapper.toDTO(savedRating);
        log.info("Rating added by customerId: {} for restaurantId: {}", userId, ratingReqDTO.getRestaurantId());
        return ratingDTO;
    }

    @Override
    public RestaurantRatingDTO getRestaurantRatingByName(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByNameIgnoreCase(restaurantName)
                .orElseThrow(() -> new NotFoundException("Restaurant not found with name: " + restaurantName));

        Double averageRating = ratingRepository.findAverageRatingByRestaurantId(restaurant.getId());

        List<Rating> ratings = ratingRepository.findByRestaurantsNameIgnoreCase(restaurantName);
        List<CommentsDTO> commentsDTOS = ratings.stream()
                .map(ratingMapper::toCommentDTO)
                .collect(Collectors.toList());

        RestaurantRatingDTO restaurantRatingDTO = new RestaurantRatingDTO();
        restaurantRatingDTO.setRestaurantName(restaurantName);
        restaurantRatingDTO.setAverageRating(averageRating);
        restaurantRatingDTO.setRatings(commentsDTOS);

        return restaurantRatingDTO;
    }
}
