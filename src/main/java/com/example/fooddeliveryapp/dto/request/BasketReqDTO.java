package com.example.fooddeliveryapp.dto.request;

import com.example.fooddeliveryapp.enums.ProductStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BasketReqDTO {
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private Long customerId;

    private Long productId;
    private Integer quantity;

    @Schema(hidden = true)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
}
