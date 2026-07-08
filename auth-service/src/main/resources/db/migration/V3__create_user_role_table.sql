CREATE TABLE IF NOT EXISTS user_db.user_roles (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,

    PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_user_roles_user
    FOREIGN KEY (user_id)
    REFERENCES user_db.users(id)
    ON DELETE CASCADE,

    CONSTRAINT fk_user_roles_role
    FOREIGN KEY (role_id)
    REFERENCES user_db.roles(id)
    ON DELETE CASCADE
    );

CREATE INDEX idx_user_roles_role
    ON user_db.user_roles(role_id);

-- Memberikan Role kepada User
INSERT INTO user_db.user_roles (user_id, role_id)
SELECT
    u.id,
    r.id
FROM user_db.users u
         JOIN user_db.roles r
              ON r.name = 'SUPER_ADMIN'
WHERE u.username = 'superadmin';

-- Menampilkan User beserta Role
SELECT
    u.username,
    u.email,
    r.name AS role
FROM user_db.users u
         JOIN user_db.user_roles ur
              ON u.id = ur.user_id
         JOIN user_db.roles r
              ON ur.role_id = r.id;