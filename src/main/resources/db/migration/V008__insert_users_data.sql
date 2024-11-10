-- Flyway migration script
-- Version: 2
-- Description: Insert 5 predefined users

INSERT INTO users (first_name,last_name, middle_name, birth_date, balance) VALUES
                                                                     ('Иван', 'Иванович','Иванов', '1992-03-15', 125.50),
                                                                     ('Петр', 'Петрович', 'Петров', '1992-11-20', 500.00),
                                                                     ('Сидор', 'Сидорович', 'Сидоров', '1978-07-05', 20.75),
                                                                     ('Анна', 'Ивановна','Абрамова', '1989-05-10', 875.25),
                                                                     ('Мария', 'Марковна', 'Макарова', '2001-02-28', 300.00);
