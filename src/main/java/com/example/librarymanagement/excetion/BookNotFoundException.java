package com.example.librarymanagement.excetion;

public class BookNotFoundException extends RuntimeException
    {
        public BookNotFoundException(String message)
            {
                super(message);
            }
    }

