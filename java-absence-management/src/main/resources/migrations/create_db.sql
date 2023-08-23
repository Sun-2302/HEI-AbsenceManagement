-- create database
drop DATABASE IF EXISTS absence_hei;

CREATE DATABASE absence_hei;

\c absence_hei;

--create table

CREATE TABLE "group"(
    id serial PRIMARY KEY,
    ref varchar(50) not null UNIQUE,
    creation_date date default current_date
);

CREATE TABLE student(
    id serial PRIMARY KEY,
    first_name varchar(250) not null,
    last_name varchar(250) not null,
    gender varchar(50),
    ref varchar(250) UNIQUE not null,
    email varchar(250) UNIQUE not null,
    phone varchar(50) UNIQUE
);

CREATE TABLE teaching_units(
    id serial PRIMARY KEY,
    name varchar(250) UNIQUE not null
);

CREATE TABLE follow(
    id serial PRIMARY KEY,
    id_student int REFERENCES student(id) not null,
    id_teaching_units int REFERENCES teaching_units(id) not null
);

CREATE TABLE course(
    id serial PRIMARY KEY,
    date_time timestamp not null,
    id_teaching_units int REFERENCES teaching_units(id),
    id_group int REFERENCES "group"(id) not null
);

CREATE TABLE absence(
    id serial PRIMARY KEY,
    id_student int REFERENCES student(id) not null,
    id_course int REFERENCES course(id) not null
);
