-- Drop table

-- DROP TABLE user_db.users;

CREATE TABLE user_db.users (
	id varchar(255) NOT NULL,
	email varchar(255) NULL,
	password varchar(255) NULL,
	phone_number varchar(255) NULL,
	role varchar(255) NULL,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

