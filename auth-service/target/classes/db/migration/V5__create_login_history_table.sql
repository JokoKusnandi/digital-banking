CREATE TABLE IF NOT EXISTS user_db.login_history (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    login_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    logout_time TIMESTAMP,

    status VARCHAR(20) NOT NULL,

    ip_address VARCHAR(45),

    browser VARCHAR(100),

    os VARCHAR(100),

    device VARCHAR(100),

    location VARCHAR(255),

    CONSTRAINT fk_login_history_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE
    );

CREATE INDEX idx_login_history_user
    ON user_db.login_history(user_id);

CREATE INDEX idx_login_history_login_time
    ON user_db.login_history(login_time);

CREATE INDEX idx_login_history_status
    ON user_db.login_history(status);


INSERT INTO user_db.login_history (
    user_id,
    login_time,
    status,
    ip_address,
    browser,
    os,
    device,
    location
)
VALUES (
           '2b59c947-fd7d-4f65-aef6-123456789abc',
           CURRENT_TIMESTAMP,
           'SUCCESS',
           '192.168.1.10',
           'Chrome 138',
           'Windows 11',
           'Desktop',
           'Jakarta, Indonesia'
       );