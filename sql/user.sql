CREATE TABLE users
(
    id bigserial NOT NULL,
    firstName varchar(70) NOT NULL,
    lastName varchar(50) NOT NULL,
    age integer,
    email varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    role varchar(20) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT email UNIQUE (email)

)