package com.habeshas.brandlocationservice.location.repository;

import com.habeshas.brandlocationservice.location.entity.RestaurantLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantLocationRepository extends JpaRepository<RestaurantLocationEntity, UUID> {
}
