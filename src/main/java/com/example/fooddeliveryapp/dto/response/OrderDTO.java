package com.example.fooddeliveryapp.dto.response;

import com.example.fooddeliveryapp.enums.OrderStatus;
import com.example.fooddeliveryapp.enums.PaymentMethods;
import lombok.Data;


@Data
public class OrderDTO {
    private Long id;
    private Long customerId;
    private Long restaurantId;
    private Double totalPrice;
    private String orderTime;
    private OrderStatus orderStatus;
    private PaymentMethods paymentMethods;
}
