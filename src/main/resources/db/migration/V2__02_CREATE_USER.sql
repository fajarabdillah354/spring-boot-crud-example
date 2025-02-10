CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    user_email VARCHAR(50) NOT NULL UNIQUE,
    user_username VARCHAR(50) NOT NULL UNIQUE,
    user_password VARCHAR(50) NOT NULL
);