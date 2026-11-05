package com.habeshas.brandlocationservice.location.dtos;

public record RestaurantLocationRequestDto(
        String locationName,
        String phone,
        String email,
        String address,
        String timeZone,
        String status) {
}
