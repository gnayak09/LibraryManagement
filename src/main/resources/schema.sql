-- Drop tables if they exist
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;

-- Create author table
CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    bio TEXT,
    email VARCHAR(255) NOT NULL UNIQUE,
    dob DATE
);

-- Create book table
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL UNIQUE,
    category VARCHAR(255),
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES author(id)
);

-- Insert authors
INSERT INTO author (name, bio, email, dob) VALUES ('Harper Lee', 'An American novelist', 'harper.lee@example.com', '1926-04-28');
INSERT INTO author (name, bio, email, dob) VALUES ('F. Scott Fitzgerald', 'An American writer', 'scott.fitzgerald@example.com', '1896-09-24');
INSERT INTO author (name, bio, email, dob) VALUES ('Stephen Hawking', 'An English theoretical physicist, cosmologist', 'stephen.hawking@example.com', '1942-01-08');
INSERT INTO author (name, bio, email, dob) VALUES ('Yuval Noah Harari', 'An Israeli public intellectual, historian', 'yuval.harari@example.com', '1976-02-24');

-- Insert books
INSERT INTO book (title, isbn, category, author_id) VALUES ('To Kill a Mockingbird', '9780060935467', 'Fiction', 1);
INSERT INTO book (title, isbn, category, author_id) VALUES ('The Great Gatsby', '9780743273565', 'Fiction', 1);
INSERT INTO book (title, isbn, category, author_id) VALUES ('Brief Answers to the Big Questions', '9781984819192', 'Science', 3);
INSERT INTO book (title, isbn, category, author_id) VALUES ('Sapiens: A Brief History of Humankind', '9780099590088', 'History', 4);
