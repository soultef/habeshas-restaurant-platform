package com.habeshas.brandlocationservice.location.mapper;

import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;
import com.habeshas.brandlocationservice.location.entity.RestaurantLocationEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestaurantLocationMapper {

    public RestaurantLocationEntity toEntity(
            RestaurantLocationRequestDto requestDto,
            RestaurantBrandEntity brand
    ) {
        return new RestaurantLocationEntity(
                brand,
                requestDto.locationName(),
                requestDto.phone(),
                requestDto.email(),
                requestDto.address(),
                requestDto.timeZone(),
                requestDto.status()
        );
    }

    public RestaurantLocationResponseDto toResponseDto(
            RestaurantLocationEntity locationEntity
    ) {
        return new RestaurantLocationResponseDto(
                locationEntity.getId(),
                locationEntity.getBrand().getId(),
                locationEntity.getLocationName(),
                locationEntity.getPhoneNumber(),
                locationEntity.getEmail(),
                locationEntity.getAddress(),
                locationEntity.getTimezone(),
                locationEntity.getCreatedAt(),
                locationEntity.getUpdatedAt(),
                locationEntity.getStatus()
        );
    }

    public void updateLocation(RestaurantLocationEntity locationEntity,
                               RestaurantLocationRequestDto requestDto)
    {
        locationEntity.setLocationName(requestDto.locationName());
        locationEntity.setAddress(requestDto.address());
        locationEntity.setEmail(requestDto.email());
        locationEntity.setPhoneNumber(requestDto.phone());
        locationEntity.setStatus(requestDto.status());
        locationEntity.setTimezone(requestDto.timeZone());
    }
}
