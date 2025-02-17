CREATE TABLE products(
    product_id VARCHAR(36),
    product_name VARCHAR(255) NOT NULL,
    product_description VARCHAR(255) NOT NULL,
    product_quantity INT DEFAULT 0,
    product_price INT DEFAULT 0,
    product_created DATE,
    product_updated DATE,
    PRIMARY KEY(product_id)
);




