    SET MODE PostgreSQL;

    CREATE TABLE IF NOT EXISTS users (
    id int serial PRIMARY KEY,
    firstName VARCHAR,
    secondName VARCHAR,
    designation VARCHAR,
    role VARCHAR,
    department_id int
    );

    CREATE TABLE IF NOT EXISTS departments (
    id int serial PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    empNo int
    );

    CREATE TABLE IF NOT EXISTS news (
    id int serial PRIMARY KEY,
    title VARCHAR,
    content VARCHAR,
    category VARCHAR
    );