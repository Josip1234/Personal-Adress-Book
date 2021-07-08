CREATE TABLE city
(
    id bigserial NOT NULL,
    name varchar(50) NOT NULL,
    zip_code varchar(10) NOT NULL,
    country_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_city UNIQUE (name)
,
    CONSTRAINT fk_country FOREIGN KEY (country_id)
        REFERENCES country (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)