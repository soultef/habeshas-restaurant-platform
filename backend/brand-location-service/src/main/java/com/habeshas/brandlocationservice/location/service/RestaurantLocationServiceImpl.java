package com.habeshas.brandlocationservice.location.service;

import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantLocationServiceImpl implements RestaurantLocationService {

    @Override
    public RestaurantLocationResponseDto createLocation(
            RestaurantLocationRequestDto request) {
        return null;
    }

    @Override
    public RestaurantLocationResponseDto getLocationById(UUID id) {
        return null;
    }

    @Override
    public List<RestaurantLocationResponseDto> getAllLocations() {
        return null;
    }

    @Override
    public List<RestaurantLocationResponseDto> getLocationsByBrandId(UUID brandId) {
        return null;
    }

    @Override
    public RestaurantLocationResponseDto updateLocation(
            UUID id,
            RestaurantLocationRequestDto request) {
        return null;
    }

    @Override
    public RestaurantLocationResponseDto updateLocationStatus(
            UUID id,
            String status) {
        return null;
    }

    @Override
    public void deleteLocation(UUID id) {
    }
}
