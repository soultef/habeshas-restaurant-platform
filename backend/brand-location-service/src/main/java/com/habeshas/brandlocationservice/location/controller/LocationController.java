package com.habeshas.brandlocationservice.location.controller;

import com.habeshas.brandlocationservice.enums.LocationStatus;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationRequestDto;
import com.habeshas.brandlocationservice.location.dtos.RestaurantLocationResponseDto;
import com.habeshas.brandlocationservice.location.service.RestaurantLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/location")
public class LocationController {

    private final RestaurantLocationService locationService;

    public LocationController(RestaurantLocationService locationService)
    {
        this.locationService = locationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantLocationResponseDto> getLocationById(@PathVariable UUID id)
    {
      RestaurantLocationResponseDto locationResponse = locationService.getLocationById(id);
      return ResponseEntity.ok(locationResponse);
    }


    @GetMapping
    public ResponseEntity<List<RestaurantLocationResponseDto>> getAllRestaurants()
    {
        List<RestaurantLocationResponseDto> allRestaurants = locationService.getAllLocations();
        return ResponseEntity.ok(allRestaurants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantLocationResponseDto> updateRestaurant(@PathVariable UUID id,
                              RestaurantLocationRequestDto updateLocation)
    {
       RestaurantLocationResponseDto updatedResponse =  locationService.updateLocation(id, updateLocation);
       return  ResponseEntity.ok(updatedResponse);
    }

    @PostMapping
    public ResponseEntity<RestaurantLocationResponseDto> createLocation( @RequestBody RestaurantLocationRequestDto locationRequestDto)
    {
       RestaurantLocationResponseDto locationResponse =  locationService.createLocation(locationRequestDto);
        return ResponseEntity.ok(locationResponse);

    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<RestaurantLocationResponseDto> updateLocationStatus( @PathVariable UUID id ,
                       @RequestParam LocationStatus locationStatus)
    {
        RestaurantLocationResponseDto responseDto = locationService.updateLocationStatus(id, locationStatus);
        return ResponseEntity.ok(responseDto);
    }

}
