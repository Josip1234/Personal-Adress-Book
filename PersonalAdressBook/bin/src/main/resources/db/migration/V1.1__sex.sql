CREATE TABLE sex
(
    id serial NOT NULL,
    name varchar(7) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_name UNIQUE (name)

)