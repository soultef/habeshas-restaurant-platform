package com.habeshas.brandlocationservice.brand.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RestaurantBrandRequestDto(


        @NotEmpty(message = "Brand name is required")
        @Size(max = 255, message = "Must not be exceed 255 characters")
        String name,

        @NotEmpty(message = "Brand description is required")
        String description) {
}
