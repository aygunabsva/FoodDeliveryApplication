package com.example.fooddeliveryapp.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RatingReqDTO {
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private Long customerId;

    @NotNull(message = "restaurant id can not be null")
    private Long restaurantId;

    @Min(value = 0)
    @Max(value = 5)
    @NotNull(message = "rating value can not be null!")
    private Integer ratingValue;

    private String comment;

    @Schema(hidden = true)
    private LocalDateTime timestamp;
}
