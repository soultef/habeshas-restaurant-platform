package com.habeshas.brandlocationservice.location.service;

import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;

import java.util.List;
import java.util.UUID;

public interface RestaurantLocationService {

    // Create a restaurant location
    RestaurantLocationResponseDto createLocation(
            RestaurantLocationRequestDto request
    );

    // Retrieve a location by ID
    RestaurantLocationResponseDto getLocationById(UUID id);

    // Retrieve all restaurant locations
    List<RestaurantLocationResponseDto> getAllLocations();

    // Retrieve locations belonging to a specific brand
    List<RestaurantLocationResponseDto> getLocationsByBrandId(UUID brandId);

    // Update an existing location
    RestaurantLocationResponseDto updateLocation(
            UUID id,
            RestaurantLocationRequestDto request
    );

    // Update location status
    RestaurantLocationResponseDto updateLocationStatus(
            UUID id,
            String status
    );

    // Delete a location
    void deleteLocation(UUID id);
}
