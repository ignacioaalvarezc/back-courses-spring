CREATE TABLE user_role (
    user_role_id BIGINT NOT NULL AUTO_INCREMENT,
    role_role_id BIGINT,
    user_user_id BIGINT,
    PRIMARY KEY (user_role_id)
) engine=InnoDB;