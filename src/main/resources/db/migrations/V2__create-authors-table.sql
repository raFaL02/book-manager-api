CREATE TABLE authors (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    biography TEXT NOT NULL,
    books_id UUID,
    FOREIGN KEY (books_id) REFERENCES books(id) ON DELETE CASCADE
);