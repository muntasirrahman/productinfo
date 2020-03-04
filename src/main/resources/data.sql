DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id BIGINT PRIMARY KEY,
    name VARCHAR,
    quantity INT ,
    sale_amount DOUBLE
);

INSERT INTO product (id, name, quantity, sale_amount) VALUES
    (1, 'Macbook Pro 16', 2, 8300.54),
    (2, 'Macbook Pro 15', 10, 43212.5),
    (3, 'Dell XPS 9750', 1, 2400.00),
    (4, 'Dell XPS 9370', 2, 3900.00)
;


