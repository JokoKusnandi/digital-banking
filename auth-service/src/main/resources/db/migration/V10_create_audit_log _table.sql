CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS user_db.audit_log (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    action VARCHAR(100) NOT NULL,

    description TEXT,

    ip VARCHAR(45),

    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_audit_log_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE
    );

CREATE INDEX idx_audit_log_user
    ON user_db.audit_log(user_id);

CREATE INDEX idx_audit_log_action
    ON user_db.audit_log(action);

CREATE INDEX idx_audit_log_created_date
    ON user_db.audit_log(created_date);


INSERT INTO user_db.audit_log (
    user_id,
    action,
    description,
    ip
)
VALUES (
           '2b59c947-fd7d-4f65-aef6-123456789abc',
           'LOGIN_SUCCESS',
           'User successfully logged in using web application.',
           '192.168.1.100'
       );