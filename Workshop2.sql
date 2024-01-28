drop database if exists workshop2;

CREATE DATABASE workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use workshop2;

create table users
(
    id       int(11) auto_increment primary key,
    email    varchar(255) not null,
    username varchar(255) not null,
    password varchar(60)  not null,
    constraint users_email unique (email)
);