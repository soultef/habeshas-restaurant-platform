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
    private final RestaurantBrandMapper brandMapper;

    public RestaurantBrandServiceImpl(RestaurantBrandRepository brandRepository,
                                      RestaurantBrandMapper toResponse, RestaurantBrandMapper brandMapper)
    {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;

    }



    @Override
    public RestaurantBrandResponseDto getBrandById(UUID id) {

        RestaurantBrandEntity brandEntity = brandRepository.findById(id)
                .orElseThrow(() ->
                        new BrandNotFoundException(id));

        return brandMapper.toResponseDto(brandEntity);
    }

    @Override
    public RestaurantBrandResponseDto updateBrand(
            UUID id,
            RestaurantBrandRequestDto brandRequestDto) {

        RestaurantBrandEntity brandEntity = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        brandMapper.updateBrand(brandRequestDto, brandEntity);
        brandRepository.save(brandEntity);
        return brandMapper.toResponseDto(brandEntity);
    }

    @Override
    public RestaurantBrandEntity getRestaurantBrand() {

        return brandRepository
                .findFirstByOrderByCreatedAtAsc()
                .orElseThrow(BrandNotFoundException::new);
    }

}
