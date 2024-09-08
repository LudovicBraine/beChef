CREATE SEQUENCE IF NOT EXISTS book_id_sequence;

CREATE TABLE book
(
    id int8 primary key not null default nextval('book_id_sequence'),
    title            VARCHAR(255),
    image            VARCHAR(100),
    description      TEXT,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    display          BOOLEAN,
    last_modified_by VARCHAR(50),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_book_user_id ON book(user_id);

CREATE SEQUENCE IF NOT EXISTS page_id_sequence;

CREATE TABLE page (
    id int8 primary key not null default nextval('page_id_sequence'),
    title VARCHAR(255),
    image VARCHAR(100),
    content TEXT,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    display          BOOLEAN,
    last_modified_by VARCHAR(50),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    book_id BIGINT,
    FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);

CREATE INDEX idx_page_user_id ON page(user_id);
CREATE INDEX idx_page_book_id ON page(book_id);

CREATE TABLE book_user (
book_id BIGINT,
user_id BIGINT,
PRIMARY KEY (book_id, user_id),
CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book(id),
CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Créer un index sur la colonne product_id
CREATE INDEX idx_book_page_book_id ON book_user(book_id);

-- Créer un index sur la colonne category_id
CREATE INDEX idx_book_user_user_id ON book_user(user_id);
