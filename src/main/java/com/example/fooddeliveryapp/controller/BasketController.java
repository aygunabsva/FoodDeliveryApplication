package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import com.example.fooddeliveryapp.service.BasketServive;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("edit/{basketId}")
    @ResponseStatus(HttpStatus.OK)
    public BasketDTO updateBasket(@PathVariable Long basketId, @RequestParam Integer quantity) {
        return basketServive.updateBasket(basketId, quantity);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BasketDTO> getByCustomer(HttpServletRequest request) {
        return basketServive.getByCustomerId(request);
    }

    @DeleteMapping("/{basketId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Void delete(@PathVariable Long basketId) {
        basketServive.delete(basketId);
        return null;
    }


}
