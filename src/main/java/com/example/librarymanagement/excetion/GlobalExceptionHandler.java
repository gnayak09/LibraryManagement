package com.example.librarymanagement.excetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler
    {
        @ExceptionHandler(AuthorNotFoundException.class)
        public ResponseEntity<Error> handleAuthorNotFoundException(AuthorNotFoundException ex, WebRequest request)
            {
                Error e = new Error(HttpStatus.NOT_FOUND.toString(),ex.getMessage());
                return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
            }

        @ExceptionHandler(BookNotFoundException.class)
        public ResponseEntity<Error> handleBookNotFoundException(BookNotFoundException ex, WebRequest request)
            {
                Error e = new Error(HttpStatus.NOT_FOUND.toString(),ex.getMessage());
                return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
            }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Error> handleException(Exception ex, WebRequest webRequest)
            {
                Error e = new Error("UNKNOWN",ex.getMessage());
                return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
            }
    }
