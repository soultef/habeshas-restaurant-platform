package com.habeshas.brandlocationservice.brand.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantBrandResponseDto(
        UUID id,
        String name,
        String description,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
