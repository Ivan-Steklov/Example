
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       middle_name VARCHAR(255) NOT NULL,
                       birth_date DATE,
                       balance DECIMAL(10, 2) DEFAULT 0.00
);
