CREATE TABLE user_cars (
                           user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
                           car_id INTEGER REFERENCES cars(id) ON DELETE CASCADE,
                           PRIMARY KEY (user_id, car_id)
);