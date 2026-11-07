package com.habeshas.brandlocationservice.location.dtos;

import com.habeshas.brandlocationservice.enums.LocationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantLocationResponseDto(
        UUID id,
        UUID brandId,
        String locationName,
        String phone,
        String email,
        String address,
        String timezone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocationStatus status
) {}
