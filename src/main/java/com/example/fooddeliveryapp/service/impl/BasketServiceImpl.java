package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.BasketReqDTO;
import com.example.fooddeliveryapp.dto.response.BasketDTO;
import com.example.fooddeliveryapp.entity.Basket;
import com.example.fooddeliveryapp.entity.Customer;
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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        double totalPrice = product.getPrice() * basketDTO.getQuantity();
        basketDTO.setTotalPrice(totalPrice);

        //Basket basket = basketMapper.toEntity(basketDTO);
        Basket savedBasket = basketRepository.save(basketMapper.toEntity(basketDTO));
        BasketDTO savedBasketDTO = basketMapper.toDTO(savedBasket);
        log.info("Created a basket with the ID: {}", savedBasket.getId());
        return savedBasketDTO;
    }

    @Override
    public BasketDTO updateBasket(Long basketId, Integer quantity) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new NotFoundException("Basket not found with id: " + basketId));

        if (quantity <= 0) {
            throw new BadRequestException("Quantity must be greater than zero");
        }
        Product product = basket.getProduct();
        if (product == null) {
            throw new NotFoundException("Product not found in the basket");
        }
        basket.setQuantity(quantity);
        double totalPrice = product.getPrice() * quantity;
        basket.setTotalPrice(totalPrice);

        Basket updatedBasket = basketRepository.save(basket);
        BasketDTO basketDTO = basketMapper.toDTO(updatedBasket);
        log.info("Updated a basket with the ID: {}", basket.getId());
        return basketDTO;
    }

    @Override
    public void delete(Long basketId) {
        log.info("Basket delete method started");
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new NotFoundException("Basket not found with id: " + basketId));
        basketRepository.delete(basket);
        log.info("Deleted a basket with the ID: {}", basket.getId());
    }

    @Override
    public List<BasketDTO> getByCustomerId(HttpServletRequest request) {
        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
        log.info("Basket add method started by userId: {}", userId);
        Long customerId = customerRepository.findByUserId(Long.valueOf(userId)).getId();
        Customer customer = new Customer();
        customer.setId(customerId);

        List<Basket> baskets = basketRepository.findByCustomerId(customer.getId());
        List<BasketDTO> basketDTOS = baskets.stream()
                .map(basketMapper::toDTO)
                .collect(Collectors.toList());
        log.info("Found {} products in basket for a customer ID: {}", baskets.size(), customerId);
        return basketDTOS;
    }
}
