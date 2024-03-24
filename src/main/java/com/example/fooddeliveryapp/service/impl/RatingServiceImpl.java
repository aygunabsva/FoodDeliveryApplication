package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import com.example.fooddeliveryapp.entity.Rating;
import com.example.fooddeliveryapp.mapper.RatingMapper;
import com.example.fooddeliveryapp.repository.CustomerRepository;
import com.example.fooddeliveryapp.repository.RatingRepository;
import com.example.fooddeliveryapp.service.RatingService;
import com.example.fooddeliveryapp.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final CustomerRepository customerRepository;
    private final RatingMapper ratingMapper;
    private final JwtUtil jwtUtil;

    @Override
    public RatingDTO addRating(HttpServletRequest request, RatingReqDTO ratingReqDTO) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));

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
}
