CREATE TABLE Houses (
                        id SERIAL PRIMARY KEY,
                        city VARCHAR(100) NOT NULL,
                        street VARCHAR(100) NOT NULL,
                        house_number VARCHAR(10) NOT NULL,
                        apartment_number VARCHAR(10)
);