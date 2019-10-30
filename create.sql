    SET MODE PostgreSQL;

    CREATE DATABASE organizational_api;

    \c organizational_api;

    CREATE TABLE IF NOT EXISTS users (
    id int serial PRIMARY KEY,
    firstName VARCHAR,
    secondName VARCHAR,
    designation VARCHAR,
    role VARCHAR,
    department_id int
    );

    CREATE TABLE IF NOT EXISTS departments (
    id serial PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    empNo int
    );

    CREATE TABLE IF NOT EXISTS news (
    id serial PRIMARY KEY,
    title VARCHAR,
    content VARCHAR,
    category VARCHAR
    );

    CREATE DATABASE organizational_api_test WITH TEMPLATE organizational_api;