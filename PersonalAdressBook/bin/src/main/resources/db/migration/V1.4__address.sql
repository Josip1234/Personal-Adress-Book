CREATE TABLE address
(
    id serial NOT NULL,
    street varchar(50) NOT NULL,
    street_no varchar(5) NOT NULL,
    city_id bigint UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_city FOREIGN KEY (city_id)
        REFERENCES city (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)