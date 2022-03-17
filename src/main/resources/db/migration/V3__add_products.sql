INSERT INTO products (id, price, title)
VALUES  (1, 100.0, 'helmet'),
        (2, 200.0, 'rope'),
        (3, 150.0, 'backpack'),
        (4, 400.0, 'tent'),
        (5, 80.0, 'carabiner');

ALTER SEQUENCE product_seq RESTART WITH 7;