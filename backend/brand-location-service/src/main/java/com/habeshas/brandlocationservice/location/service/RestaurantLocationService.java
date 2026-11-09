package com.habeshas.brandlocationservice.location.service;

import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.enums.LocationStatus;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;

import java.util.List;
import java.util.UUID;

public interface RestaurantLocationService {

    RestaurantLocationResponseDto createLocation( RestaurantLocationRequestDto request);

    // Retrieve a location by ID
    RestaurantLocationResponseDto getLocationById(UUID id);

    // Retrieve all restaurant locations
    List<RestaurantLocationResponseDto> getAllLocations();


    // Update an existing location
    RestaurantLocationResponseDto updateLocation(UUID id, RestaurantLocationRequestDto request);

    // Update location status
    RestaurantLocationResponseDto updateLocationStatus(UUID id, LocationStatus status);
    RestaurantLocationResponseDto deactivateLocation(UUID id);
    RestaurantLocationResponseDto activateLocation(UUID id);
}
