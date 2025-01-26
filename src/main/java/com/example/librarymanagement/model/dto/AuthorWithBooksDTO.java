package com.example.librarymanagement.model.dto;

import java.util.List;

public class AuthorWithBooksDTO extends AuthorDTO
    {
        private List<BookDTO> books;

        public List<BookDTO> getBooks()
            {
                return books;
            }

        public void setBooks(List<BookDTO> books)
            {
                this.books = books;
            }
    }
