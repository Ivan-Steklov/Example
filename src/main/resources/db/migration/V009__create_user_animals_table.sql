CREATE TABLE user_animals (
                              user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
                              animal_id INTEGER REFERENCES animals(id) ON DELETE CASCADE,
                              PRIMARY KEY (user_id, animal_id)
);
