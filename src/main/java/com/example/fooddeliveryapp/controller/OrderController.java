package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.request.OrderReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import com.example.fooddeliveryapp.dto.response.OrderDTO;
import com.example.fooddeliveryapp.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

//    @PostMapping("/new")
//    @ResponseStatus(HttpStatus.CREATED)
//    public OrderDTO add(HttpServletRequest request, @RequestBody OrderReqDTO orderReqDTO) {
//        return orderService.add(request, orderReqDTO);
//    }
}
