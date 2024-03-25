package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import com.example.fooddeliveryapp.service.BasketServive;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {
    private final BasketServive basketServive;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public BasketDTO add(HttpServletRequest request, @RequestBody BasketReqDTO basketDTO) {
        return basketServive.add(request, basketDTO);
    }

    @PutMapping("/{basketId}")
    @ResponseStatus(HttpStatus.OK)
    public BasketDTO updateBasket(@PathVariable Long basketId, @RequestParam Integer quantity) {
        return basketServive.updateBasket(basketId, quantity);
    }
}
