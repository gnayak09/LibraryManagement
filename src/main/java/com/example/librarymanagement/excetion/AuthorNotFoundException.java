package com.example.librarymanagement.excetion;

public class AuthorNotFoundException extends RuntimeException
    {
        public AuthorNotFoundException(String message)
            {
                super(message);
            }
    }

