CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS user_db.password_history (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    changed_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_password_history_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE
    );

CREATE INDEX idx_password_history_user
    ON user_db.password_history(user_id);

CREATE INDEX idx_password_history_changed_date
    ON user_db.password_history(changed_date);

INSERT INTO user_db.password_history (
    user_id,
    password_hash,
    changed_date
)
VALUES (
           '2b59c947-fd7d-4f65-aef6-123456789abc',
           '$2a$12$8QjVQm3D5i8B6XvD6Yg6Qe8lKJm2L8z2F4VY7kR1N9mP0rT5sA7bC',
           CURRENT_TIMESTAMP
       );