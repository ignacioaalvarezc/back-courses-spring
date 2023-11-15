CREATE TABLE users (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    enabled BIT NOT NULL,
    last_name VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    profile VARCHAR(255),
    phone_number VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (user_id)
) engine=InnoDB;