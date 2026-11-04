package com.habeshas.brandlocationservice.location.entity;


import com.habeshas.brandlocationservice.brand.entity.RestaurantBrandEntity;
import com.habeshas.brandlocationservice.enums.LocationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "restaurant_location")
public class RestaurantLocationEntity {

    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id", nullable = false, updatable = false, length = 36)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "brand_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_restaurant_location_brand")
    )
    private RestaurantBrandEntity brand;

    @Column(name = "location_name", nullable = false, length = 255)
    private String locationName;

    @Column(name = "phone", length = 30)
    private String phoneNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "address", nullable = false, length = 500)
    private String address;

    @Column(name = "timezone", nullable = false, length = 50)
    private String timezone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private LocationStatus status = LocationStatus.ACTIVE;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    protected RestaurantLocationEntity() {
    }


    public RestaurantLocationEntity(
            RestaurantBrandEntity brand,
            String locationName,
            String phoneNumber,
            String email,
            String address,
            String timezone
    ) {
        this.brand = Objects.requireNonNull(brand);
        this.locationName = locationName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.timezone = timezone;
    }
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public RestaurantBrandEntity getBrand() {
        return brand;
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public LocationStatus getStatus() {
        return status;
    }

    public void setStatus(LocationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


}
