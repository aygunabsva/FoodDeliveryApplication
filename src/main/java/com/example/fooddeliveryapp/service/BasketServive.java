package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface BasketServive {
    BasketDTO add(HttpServletRequest request, BasketReqDTO basketDTO);

    BasketDTO updateBasket(Long basketId, Integer quantity);

    void delete(Long basketId);

    List<BasketDTO> getByCustomerId(HttpServletRequest request);

}
