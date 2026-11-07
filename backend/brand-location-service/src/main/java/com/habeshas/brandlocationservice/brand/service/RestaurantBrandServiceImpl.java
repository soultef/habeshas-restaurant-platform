package com.habeshas.brandlocationservice.brand.service;

import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandRequestDto;
import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandResponseDto;
import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.brand.repository.RestaurantBrandRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantBrandServiceImpl implements RestaurantBrandService {

    private RestaurantBrandRepository brandRepository;

    public RestaurantBrandServiceImpl(RestaurantBrandRepository brandRepository)
    {
        this.brandRepository = brandRepository;
    }

    @Override
    public RestaurantBrandResponseDto getBrandById(UUID id)
    {
        RestaurantBrandEntity brandEnity = brandRepository.findById(id)
                .orElseThrow(() ->{return new RuntimeException("you must be right");} );

        return null;
    }


    @Override
    public RestaurantBrandResponseDto updateBrand(UUID id , RestaurantBrandRequestDto brandRequestDto)
    {
        return null;
    }

}
