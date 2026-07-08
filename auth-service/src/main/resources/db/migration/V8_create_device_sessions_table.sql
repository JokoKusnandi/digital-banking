CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS user_db.device_sessions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    device_id VARCHAR(255) NOT NULL,

    refresh_token VARCHAR(500) NOT NULL,

    active BOOLEAN NOT NULL DEFAULT TRUE,

    last_access TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    platform VARCHAR(100),

    CONSTRAINT fk_device_sessions_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE
    );


CREATE INDEX idx_device_sessions_user
    ON user_db.device_sessions(user_id);

CREATE INDEX idx_device_sessions_device
    ON user_db.device_sessions(device_id);

CREATE INDEX idx_device_sessions_active
    ON user_db.device_sessions(active);

CREATE INDEX idx_device_sessions_last_access
    ON user_db.device_sessions(last_access);

ALTER TABLE user_db.device_sessions
    ADD CONSTRAINT uk_device_sessions_user_device
        UNIQUE (user_id, device_id);


INSERT INTO user_db.device_sessions (
    user_id,
    device_id,
    refresh_token,
    active,
    last_access,
    platform
)
VALUES (
           '2b59c947-fd7d-4f65-aef6-123456789abc',
           'DESKTOP-WIN11-ABC123',
           'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...',
           TRUE,
           CURRENT_TIMESTAMP,
           'Windows 11'
       );
