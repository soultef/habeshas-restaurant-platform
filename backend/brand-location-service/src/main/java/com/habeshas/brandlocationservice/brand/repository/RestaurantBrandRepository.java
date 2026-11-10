package com.habeshas.brandlocationservice.brand.repository;

import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantBrandRepository extends JpaRepository<RestaurantBrandEntity, UUID> {

    Optional<RestaurantBrandEntity> findFirstByOrderByCreatedAtAsc();
}
