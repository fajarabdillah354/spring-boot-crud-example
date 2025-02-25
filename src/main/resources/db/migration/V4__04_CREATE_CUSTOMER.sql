-- Membuat tabel customer
CREATE TABLE customers (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Membuat tabel addresses
CREATE TABLE addresses (
    id VARCHAR(36) PRIMARY KEY,
    customer_id VARCHAR(25),
    street VARCHAR(200),
    city VARCHAR(100),
    postal_code VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Membuat tabel orders
CREATE TABLE orders (
    id VARCHAR(36) PRIMARY KEY,
    customer_id VARCHAR(25),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);