package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.dto.AuthorWithBooksDTO;
import com.example.librarymanagement.model.dto.BookWithAuthorDTO;
import com.example.librarymanagement.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookAuthorController
    {
        @Autowired
        private BookAuthorService bookAuthorService;

        // Endpoint for all books with authors' details
        @GetMapping("/books-with-author/book/{bookId}")
        public BookWithAuthorDTO getBookWithAuthorsByBookId(@PathVariable Long bookId)
            {
                return bookAuthorService.getBookWithAuthorsByBookId(bookId);
            }

        @GetMapping("/books-with-author/book")
        public List<BookWithAuthorDTO> getAllBooksWithAuthor()
            {
                return bookAuthorService.getAllBooksWithAuthors();
            }

        // Endpoint for author info with their books
        @GetMapping("/author-with-books/author/{authorId}")
        public AuthorWithBooksDTO getAuthorWithBooksByAuthorID(@PathVariable Long authorId)
            {
                return bookAuthorService.getAuthorWithBooksByAuthorID(authorId);
            }

        @GetMapping("/author-with-books/author")
        public List<AuthorWithBooksDTO> getAuthorWithBooks()
            {
                return bookAuthorService.getAuthorWithBooks();
            }
    }
