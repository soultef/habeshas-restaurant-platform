CREATE TABLE restaurant_brand
(
    id           CHAR(36)     NOT NULL,
    brand_name   VARCHAR(255) NOT NULL,
    description  TEXT,
    status       VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE',
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT pk_restaurant_brand PRIMARY KEY (id),
    CONSTRAINT uk_restaurant_brand_name UNIQUE (brand_name),
    CONSTRAINT chk_restaurant_brand_status
        CHECK (status IN ('ACTIVE', 'INACTIVE'))
);


INSERT INTO restaurant_brand (
    id,
    brand_name,
    description,
    status
)
VALUES (
           UUID(),
           'Habeshas',
           'Habeshas is an Ethiopian restaurant offering traditional Ethiopian cuisine, authentic flavors, and a welcoming dining experience.',
           'ACTIVE'
       );