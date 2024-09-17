CREATE TABLE country
(
    id serial NOT NULL,
    name varchar(50) NOT NULL,
    alpha_2 varchar(2),
    alpha_3 varchar(3),
    PRIMARY KEY (id),
    CONSTRAINT uk_name2 UNIQUE (name)
,
    CONSTRAINT uk_alpha_2 UNIQUE (alpha_2)
,
    CONSTRAINT uk_alpha_3 UNIQUE (alpha_3)

)