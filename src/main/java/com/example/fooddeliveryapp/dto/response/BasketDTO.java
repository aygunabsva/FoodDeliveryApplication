package com.example.fooddeliveryapp.dto.response;

import com.example.fooddeliveryapp.enums.ProductStatus;
import lombok.Data;

@Data
public class BasketDTO {
    private Long id;
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
    private ProductStatus productStatus;
}
