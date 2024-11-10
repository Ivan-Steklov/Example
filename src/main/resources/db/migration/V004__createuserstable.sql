
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       full_name VARCHAR(255) NOT NULL,
                       birthdate DATE,
                       balance DECIMAL(10, 2) DEFAULT 0.00
);

