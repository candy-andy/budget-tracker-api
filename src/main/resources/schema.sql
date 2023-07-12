CREATE TABLE IF NOT EXISTS users (
    id          INT             PRIMARY KEY AUTO_INCREMENT,
    email       VARCHAR(255)    NOT NULL UNIQUE,
    password    VARCHAR(255)    NOT NULL,
    balance     DECIMAL(8,2)    NOT NULL DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS categories (
	id      INT             PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(255)    NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS expenses (
	id              INT                         PRIMARY KEY AUTO_INCREMENT,
    amount          DECIMAL(6,2)                NOT NULL,
    title           VARCHAR(255)                NOT NULL,
    type            ENUM('income', 'expense')   NOT NULL,
    date            DATE                        NOT NULL,
    category_id     INT,
    description     TEXT,
    INDEX category_index (category_id),
    FOREIGN KEY (category_id)
        REFERENCES categories (id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);
