INSERT INTO users (id, archive, email, name, password, role)
VALUES (1, false, 'mail@mail.ru', 'admin', '1212', 'ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;