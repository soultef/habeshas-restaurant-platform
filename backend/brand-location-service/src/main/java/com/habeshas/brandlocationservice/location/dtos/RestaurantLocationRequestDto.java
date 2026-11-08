package com.habeshas.brandlocationservice.location.dtos;

import com.habeshas.brandlocationservice.enums.LocationStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RestaurantLocationRequestDto(

        @NotBlank(message = "Location name is required")
        @Size(max = 255, message = "Location name must not exceed 255 characters")
        String locationName,

        @NotBlank(message = "Phone number is required")
        @Size(max = 20, message = "Phone number must not exceed 20 characters")
        String phone,

        @NotBlank(message = "Email is required")
        @Email(message = "Please provide a valid email address")
        @Size(max = 255, message = "Email must not exceed 255 characters")
        String email,

        @NotBlank(message = "Address is required")
        @Size(max = 255, message = "Address must not exceed 255 characters")
        String address,

        @NotBlank(message = "Time zone is required")
        @Size(max = 50, message = "Time zone must not exceed 100 characters")
        String timeZone,

        @NotNull(message = "Location status is required")
        LocationStatus status

) {
}