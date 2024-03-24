package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import com.example.fooddeliveryapp.service.RatingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<RatingDTO> addRating(HttpServletRequest request, @RequestBody RatingReqDTO ratingReqDTO) {
        RatingDTO addedRating = ratingService.addRating(request, ratingReqDTO);
        return new ResponseEntity<>(addedRating, HttpStatus.CREATED);
    }
}
