CREATE TABLE IF NOT EXISTS user_db.failed_login (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL UNIQUE,

    attempt_count INTEGER NOT NULL DEFAULT 0,

    locked_until TIMESTAMP,

    last_attempt TIMESTAMP,

    CONSTRAINT fk_failed_login_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE
    );


CREATE INDEX idx_failed_login_locked_until
    ON user_db.failed_login(locked_until);

INSERT INTO user_db.failed_login (
    user_id,
    attempt_count,
    locked_until,
    last_attempt
)
VALUES (
           '2b59c947-fd7d-4f65-aef6-123456789abc',
           3,
           '2026-07-07 15:30:00',
           CURRENT_TIMESTAMP
       );