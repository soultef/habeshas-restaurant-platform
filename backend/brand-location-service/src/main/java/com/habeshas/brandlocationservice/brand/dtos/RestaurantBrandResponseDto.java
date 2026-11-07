package com.habeshas.brandlocationservice.brand.dtos;

import com.habeshas.brandlocationservice.enums.BrandStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantBrandResponseDto(
        UUID id,
        String name,
        String description,
        BrandStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
