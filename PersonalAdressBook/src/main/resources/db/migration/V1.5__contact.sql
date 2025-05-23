CREATE TABLE contact
(
    id serial NOT NULL,
    first_name varchar(20) NOT NULL,
    last_name varchar(50) NOT NULL,
    phone varchar(13) NOT NULL,
    email varchar(50) NOT NULL,
    sex_id bigint UNSIGNED NOT NULL,
    address_id bigint UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_sex FOREIGN KEY (sex_id)
        REFERENCES sex (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_address FOREIGN KEY (address_id)
        REFERENCES address (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)