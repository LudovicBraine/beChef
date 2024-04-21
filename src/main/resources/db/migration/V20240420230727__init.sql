CREATE SEQUENCE IF NOT EXISTS user_id_sequence;

CREATE TABLE users (
    id int8 primary key not null default nextval('user_id_sequence'),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

ALTER SEQUENCE user_id_sequence OWNED BY users.id;

CREATE SEQUENCE IF NOT EXISTS refresh_id_sequence;

CREATE TABLE refresh_token (
    id int8 primary key not null default nextval('refresh_id_sequence'),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    token VARCHAR(255) UNIQUE NOT NULL,
    expiry_date TIMESTAMP NOT NULL,
    revoked BOOLEAN NOT NULL
);

ALTER SEQUENCE refresh_id_sequence OWNED BY refresh_token.id;

CREATE INDEX idx_user_id ON refresh_token (user_id);