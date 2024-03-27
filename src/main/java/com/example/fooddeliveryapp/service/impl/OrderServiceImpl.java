package com.example.fooddeliveryapp.service.impl;

import com.example.fooddeliveryapp.dto.request.OrderReqDTO;
import com.example.fooddeliveryapp.dto.response.OrderDTO;
import com.example.fooddeliveryapp.entity.Basket;
import com.example.fooddeliveryapp.entity.Customer;
import com.example.fooddeliveryapp.entity.Order;
import com.example.fooddeliveryapp.entity.Restaurant;
import com.example.fooddeliveryapp.enums.ProductStatus;
import com.example.fooddeliveryapp.exception.NotFoundException;
import com.example.fooddeliveryapp.mapper.OrderMapper;
import com.example.fooddeliveryapp.repository.BasketRepository;
import com.example.fooddeliveryapp.repository.CustomerRepository;
import com.example.fooddeliveryapp.repository.OrderRepository;
import com.example.fooddeliveryapp.repository.RestaurantRepository;
import com.example.fooddeliveryapp.service.OrderService;
import com.example.fooddeliveryapp.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final BasketRepository basketRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderMapper orderMapper;
    private final JwtUtil jwtUtil;

//    @Override
//    @Transactional
//    public OrderDTO add(HttpServletRequest request, OrderReqDTO orderReqDTO) {
//        Integer userId = jwtUtil.getUserId(jwtUtil.resolveClaims(request));
//        log.info("Order add method started by userId: {}", userId);
//        Long customerId = customerRepository.findByUserId(Long.valueOf(userId)).getId();
//        Customer customer = new Customer();
//        customer.setId(customerId);
//        List<Basket> unorderedBaskets = basketRepository.findByCustomerIdAndProductStatus(customerId, ProductStatus.UNORDERED);
//        if (unorderedBaskets.isEmpty()) {
//            throw new NotFoundException("No unordered items found in the basket for customer ID: " + customerId);
//        }
//
//        Double totalPrice = unorderedBaskets.stream()
//                .mapToDouble(Basket::getTotalPrice)
//                .sum();
//
////        Restaurant restaurant = restaurantRepository.findRestaurantByCustomerId(customerId);
////        restaurant.setId(orderReqDTO.getRestaurantId());
////        unorderedBaskets.forEach(basket -> basket.setProductStatus(ProductStatus.ORDERED));
////        basketRepository.saveAll(unorderedBaskets);
//
//        Order order = new Order();
////        order.setCustomer(customer);
////        order.setRestaurant(restaurant);
//        orderMapper.toEntity(orderReqDTO);
//        order.setTotalPrice(totalPrice);
//        orderRepository.save(order);
//
//        for (Basket basket : unorderedBaskets) {
//            basket.setProductStatus(ProductStatus.ORDERED);
//        }
//        basketRepository.saveAll(unorderedBaskets);
//
//        OrderDTO orderDTO = orderMapper.toDTO(order);
//        return orderDTO;
//    }
}
