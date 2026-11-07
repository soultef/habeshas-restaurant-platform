package com.habeshas.brandlocationservice.location.dtos;

import com.habeshas.brandlocationservice.enums.LocationStatus;

public record RestaurantLocationRequestDto(
        String locationName,
        String phone,
        String email,
        String address,
        String timeZone,
        LocationStatus status) {
}
