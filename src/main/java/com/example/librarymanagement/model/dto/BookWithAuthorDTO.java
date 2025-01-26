package com.example.librarymanagement.model.dto;

public class BookWithAuthorDTO extends BookDTO
    {
        private AuthorDTO author;

        public AuthorDTO getAuthor()
            {
                return author;
            }

        public void setAuthor(AuthorDTO author)
            {
                this.author = author;
            }
    }
