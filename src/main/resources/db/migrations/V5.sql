ALTER TABLE user_role
    ADD CONSTRAINT FK8gp8vkivqjo8us69ct7b35vl
        FOREIGN KEY (user_user_id)
            REFERENCES users (user_id);