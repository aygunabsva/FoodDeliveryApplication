package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import com.example.fooddeliveryapp.entity.Basket;
import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.exception.BadRequestException;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.mapper.BasketMapper;
import com.example.fooddeliveryapp.repository.BasketRepository;
import com.example.fooddeliveryapp.repository.CustomerRepository;
import com.example.fooddeliveryapp.repository.ProductRepository;
import com.example.fooddeliveryapp.service.BasketServive;
import com.example.fooddeliveryapp.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketServive {
    private final BasketMapper basketMapper;
    private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final JwtUtil jwtUtil;

    @Override
    public BasketDTO add(HttpServletRequest request, BasketReqDTO basketDTO) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("Basket add method started by userId: {}", userId);
        Long customerId = customerRepository.findByUserId(Long.valueOf(userId)).getId();
        basketDTO.setCustomerId(customerId);

        Product product = productRepository.findById(basketDTO.getProductId())
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + basketDTO.getProductId()));

        // Calculate total price
        double totalPrice = product.getPrice() * basketDTO.getQuantity();
        basketDTO.setTotalPrice(totalPrice);

        Basket basket = basketMapper.toEntity(basketDTO);
        Basket savedBasket = basketRepository.save(basket);
        return basketMapper.toDTO(savedBasket);
    }

    @Override
    public BasketDTO updateBasket(Long basketId, Integer quantity) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new NotFoundException("Basket not found with id: " + basketId));

        // Validate quantity
        if (quantity <= 0) {
            throw new BadRequestException("Quantity must be greater than zero");
        }

        // Fetch product from basket
        Product product = basket.getProduct();
        if (product == null) {
            throw new NotFoundException("Product not found in the basket");
        }

        // Update quantity and total price
        basket.setQuantity(quantity);
        double totalPrice = product.getPrice() * quantity;
        basket.setTotalPrice(totalPrice);

        // Save updated basket
        Basket updatedBasket = basketRepository.save(basket);
        return basketMapper.toDTO(updatedBasket);
    }
}
