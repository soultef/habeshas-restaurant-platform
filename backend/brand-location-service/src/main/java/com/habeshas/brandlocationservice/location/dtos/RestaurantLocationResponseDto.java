package com.habeshas.brandlocationservice.location.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantLocationResponseDto(
        UUID id,
        UUID brandId,
        String name,
        String phone,
        String email,
        String address,
        String timezone,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
