CREATE TABLE books (
    id UUID PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    genres VARCHAR(50) NOT NULL ,
    publishDate TIMESTAMP NOT NULL,
    authors_id UUID,
    FOREIGN KEY (authors_id) REFERENCES authors(id) ON DELETE CASCADE
);