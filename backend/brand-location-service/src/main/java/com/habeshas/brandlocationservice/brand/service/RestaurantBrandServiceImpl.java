package com.habeshas.brandlocationservice.brand.service;

import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandRequestDto;
import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandResponseDto;
import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.brand.mapper.RestaurantBrandMapper;
import com.habeshas.brandlocationservice.brand.repository.RestaurantBrandRepository;
import com.habeshas.brandlocationservice.exception.BrandNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestaurantBrandServiceImpl implements RestaurantBrandService {

    private final RestaurantBrandRepository brandRepository;
    private final RestaurantBrandMapper toResponse;

    public RestaurantBrandServiceImpl(RestaurantBrandRepository brandRepository,
                                      RestaurantBrandMapper toResponse)
    {
        this.brandRepository = brandRepository;
        this.toResponse = toResponse;
    }

    @Override
    public RestaurantBrandResponseDto getBrandById(UUID id) {

        RestaurantBrandEntity brandEntity = brandRepository.findById(id)
                .orElseThrow(() ->
                        new BrandNotFoundException(id));

        return toResponse.toResponseDto(brandEntity);
    }


    @Override
    public RestaurantBrandResponseDto updateBrand(
            UUID id,
            RestaurantBrandRequestDto brandRequestDto) {

        RestaurantBrandEntity brandEntity = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        toResponse.updateBrand(brandRequestDto, brandEntity);

        RestaurantBrandEntity updatedBrand = brandRepository.save(brandEntity);

        return toResponse.toResponseDto(updatedBrand);
    }

}
