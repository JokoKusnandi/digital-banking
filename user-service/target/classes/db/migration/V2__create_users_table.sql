CREATE SCHEMA IF NOT EXISTS user_db;

CREATE TABLE IF NOT EXISTS user_db.users (
    id UUID PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) UNIQUE,

    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(150) NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    account_non_locked BOOLEAN NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    account_non_expired BOOLEAN NOT NULL DEFAULT TRUE,

    last_login TIMESTAMP,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,

    created_by VARCHAR(100),
    updated_by VARCHAR(100)
    );

CREATE INDEX idx_users_email ON user_db.users(email);


ALTER TABLE user_db.users
    ADD CONSTRAINT chk_user_status
        CHECK (status IN (
                          'ACTIVE',
                          'INACTIVE',
                          'LOCKED',
                          'SUSPENDED',
                          'DELETED'
            ));
