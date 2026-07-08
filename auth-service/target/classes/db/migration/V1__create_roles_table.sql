INSERT INTO user_db.roles (name, description)
VALUES
    ('SUPER_ADMIN', 'Super Administrator with full system access'),
    ('ADMIN', 'Administrator'),
    ('CUSTOMER', 'Customer'),
    ('AUDITOR', 'Auditor'),
    ('SUPPORT', 'Support Staff')
    ON CONFLICT (name) DO NOTHING;