package com.habeshas.brandlocationservice.location.service;

import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.brand.mapper.RestaurantBrandMapper;
import com.habeshas.brandlocationservice.brand.repository.RestaurantBrandRepository;
import com.habeshas.brandlocationservice.brand.service.RestaurantBrandService;
import com.habeshas.brandlocationservice.exception.BrandNotFoundException;
import com.habeshas.brandlocationservice.exception.LocationNotFoundException;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;
import com.habeshas.brandlocationservice.location.entity.RestaurantLocationEntity;
import com.habeshas.brandlocationservice.location.mapper.RestaurantLocationMapper;
import com.habeshas.brandlocationservice.location.repository.RestaurantLocationRepository;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantLocationServiceImpl implements RestaurantLocationService {


    private final  RestaurantLocationRepository locationRepository;
    private final RestaurantLocationMapper locationMapper;
    private final RestaurantBrandService brandService;


    public RestaurantLocationServiceImpl(RestaurantLocationRepository locationRepository,
                                         RestaurantLocationMapper locationMapper,
                                         RestaurantBrandService brandService) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
        this.brandService = brandService;
    }

    @Override
    public RestaurantLocationResponseDto createLocation(
            RestaurantLocationRequestDto requestDto) {

        RestaurantBrandEntity brand = brandService.getRestaurantBrand();

        RestaurantLocationEntity locationEntity =
                locationMapper.toEntity(requestDto, brand);

        RestaurantLocationEntity savedLocation =
                locationRepository.save(locationEntity);

        return locationMapper.toResponseDto(savedLocation);
    }

    @Override
    public RestaurantLocationResponseDto getLocationById(UUID id)
    {
       RestaurantLocationEntity location = locationRepository.findById(id)
               .orElseThrow(() -> new LocationNotFoundException(id));

        return locationMapper.toResponseDto(location);
    }

    @Override
    public List<RestaurantLocationResponseDto> getAllLocations() {

        List<RestaurantLocationEntity> allLocations =
                locationRepository.findAll();

        return allLocations.stream()
                .map(locationMapper::toResponseDto)
                .toList();
    }


}
