package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface RatingService {
    RatingDTO addRating(HttpServletRequest request, RatingReqDTO ratingReqDTO);
}
