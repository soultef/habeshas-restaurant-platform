package com.habeshas.brandlocationservice.location.mapper;

import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;
import com.habeshas.brandlocationservice.location.entity.RestaurantLocationEntity;
import org.springframework.stereotype.Component;

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

    public RestaurantLocationResponseDto toDto(
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
}
