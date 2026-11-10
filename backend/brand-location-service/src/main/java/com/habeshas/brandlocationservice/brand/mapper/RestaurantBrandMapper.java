package com.habeshas.brandlocationservice.brand.mapper;

import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandRequestDto;
import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandResponseDto;
import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import org.springframework.stereotype.Component;

@Component
public class RestaurantBrandMapper {

    public RestaurantBrandEntity toBrand(RestaurantBrandRequestDto requestDto) {
        return RestaurantBrandEntity.create(requestDto.name(), requestDto.description());
    }


    public RestaurantBrandResponseDto toResponseDto(
            RestaurantBrandEntity entity
    ) {
        return new RestaurantBrandResponseDto(
                entity.getId(),
                entity.getBrandName(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public void updateBrand(
            RestaurantBrandRequestDto requestDto,
            RestaurantBrandEntity entity
    ) {
        entity.setBrandName(requestDto.name());
        entity.setDescription(requestDto.description());
    }
}
