CREATE TABLE IF NOT EXISTS user_db.refresh_tokens (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    token VARCHAR(500) NOT NULL UNIQUE,

    device_id VARCHAR(255),

    ip_address VARCHAR(45),

    user_agent TEXT,

    expires_at TIMESTAMP NOT NULL,

    revoked BOOLEAN NOT NULL DEFAULT FALSE,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_refresh_tokens_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE
    );


CREATE INDEX idx_refresh_token_user
    ON user_db.refresh_tokens(user_id);

CREATE INDEX idx_refresh_token_expires
    ON user_db.refresh_tokens(expires_at);

CREATE INDEX idx_refresh_token_revoked
    ON user_db.refresh_tokens(revoked);