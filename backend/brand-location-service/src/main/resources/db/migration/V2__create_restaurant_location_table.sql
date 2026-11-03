CREATE TABLE restaurant_location
(
    id             CHAR(36)     NOT NULL,
    brand_id       CHAR(36)     NOT NULL,
    location_name  VARCHAR(255) NOT NULL,
    phone          VARCHAR(30),
    email          VARCHAR(255),
    address        VARCHAR(500) NOT NULL,
    timezone       VARCHAR(50)  NOT NULL,
    status         VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE',
    created_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT pk_restaurant_location PRIMARY KEY (id),

    CONSTRAINT fk_restaurant_location_brand
        FOREIGN KEY (brand_id)
            REFERENCES restaurant_brand (id),

    CONSTRAINT uk_restaurant_location_brand_name
        UNIQUE (brand_id, location_name),

    CONSTRAINT chk_restaurant_location_status
        CHECK (status IN ('ACTIVE', 'INACTIVE')),

    INDEX idx_restaurant_location_brand_id (brand_id)
);