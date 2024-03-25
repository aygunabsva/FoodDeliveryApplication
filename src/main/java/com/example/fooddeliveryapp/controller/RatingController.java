package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import com.example.fooddeliveryapp.service.RatingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public RatingDTO add(HttpServletRequest request, @RequestBody RatingReqDTO ratingReqDTO) {
        return ratingService.add(request, ratingReqDTO);
    }
}
