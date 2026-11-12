package com.habeshas.brandlocationservice.brand.controller;


import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandRequestDto;
import com.habeshas.brandlocationservice.brand.dtos.RestaurantBrandResponseDto;
import com.habeshas.brandlocationservice.brand.service.RestaurantBrandService;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final RestaurantBrandService restaurantBrand;

    BrandController(RestaurantBrandService restaurantBrand)
    {
        this.restaurantBrand = restaurantBrand;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantBrandResponseDto> getBrandById(@PathVariable UUID id) {

        RestaurantBrandResponseDto response = restaurantBrand.getBrandById(id);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantBrandResponseDto> updateBrand(@PathVariable UUID id,
                 @RequestBody RestaurantBrandRequestDto requestDto)
    {
        RestaurantBrandResponseDto updatedBrand = restaurantBrand.updateBrand(id, requestDto);
        return ResponseEntity.ok(updatedBrand);

    }


}
