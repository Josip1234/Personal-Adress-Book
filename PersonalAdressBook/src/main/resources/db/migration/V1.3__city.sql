CREATE TABLE city
(
    id serial NOT NULL,
    name varchar(50) NOT NULL,
    zip_code varchar(10) NOT NULL,
    country_id bigint(20) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_city UNIQUE (name)

  
)