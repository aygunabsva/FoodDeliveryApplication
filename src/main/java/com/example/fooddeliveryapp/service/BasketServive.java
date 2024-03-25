package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface BasketServive {
    BasketDTO add(HttpServletRequest request, BasketReqDTO basketDTO);

    BasketDTO updateBasket(Long basketId, Integer quantity);
}
