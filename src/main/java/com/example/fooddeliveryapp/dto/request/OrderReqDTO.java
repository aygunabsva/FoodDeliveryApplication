package com.example.fooddeliveryapp.dto.request;

import com.example.fooddeliveryapp.enums.OrderStatus;
import com.example.fooddeliveryapp.enums.PaymentMethods;
import com.example.fooddeliveryapp.enums.ProductStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderReqDTO {
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private Long customerId;

    @Schema(hidden = true)
    private Long restaurantId;

    @Schema(hidden = true)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @Schema(hidden = true)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Schema(hidden = true)
    private LocalDateTime orderTime;
}
