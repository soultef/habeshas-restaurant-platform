package com.habeshas.brandlocationservice.brand.service;

import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandRequestDto;
import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandResponseDto;
import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;

import java.util.UUID;

public interface RestaurantBrandService {

    RestaurantBrandResponseDto getBrandById(UUID id);
    RestaurantBrandResponseDto updateBrand(UUID id, RestaurantBrandRequestDto brand);
    RestaurantBrandEntity getRestaurantBrand();
}
