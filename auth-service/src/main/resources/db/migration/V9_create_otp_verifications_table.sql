CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS user_db.otp_verifications (
                                                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    otp VARCHAR(255) NOT NULL,

    purpose VARCHAR(30) NOT NULL,

    expired_at TIMESTAMP NOT NULL,

    verified BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT fk_otp_verification_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE,

    CONSTRAINT chk_otp_purpose
    CHECK (purpose IN (
           'LOGIN',
           'REGISTER',
           'RESET_PASSWORD',
           'CHANGE_EMAIL'
                      ))
    );

CREATE INDEX idx_otp_user
    ON user_db.otp_verifications(user_id);

CREATE INDEX idx_otp_expired
    ON user_db.otp_verifications(expired_at);

CREATE INDEX idx_otp_verified
    ON user_db.otp_verifications(verified);

CREATE INDEX idx_otp_purpose
    ON user_db.otp_verifications(purpose);

INSERT INTO user_db.otp_verifications (
    user_id,
    otp,
    purpose,
    expired_at,
    verified
)
VALUES (
           '2b59c947-fd7d-4f65-aef6-123456789abc',
           '834521',
           'LOGIN',
           CURRENT_TIMESTAMP + INTERVAL '5 minutes',
           FALSE
       );