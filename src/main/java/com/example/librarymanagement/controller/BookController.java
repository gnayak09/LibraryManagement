package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.dao.Book;
import com.example.librarymanagement.model.dto.BookDTO;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController
    {

        @Autowired
        private BookService bookService;

        @GetMapping("/{id}")
        public ResponseEntity<BookDTO> getBookById(@PathVariable Long id)
            {
                return ResponseEntity.ok(bookService.getBookById(id));
            }

        @GetMapping
        public ResponseEntity<List<BookDTO>> getAllBooks()
            {
                return ResponseEntity.ok(bookService.getAllBooks());
            }

        @PostMapping
        public ResponseEntity<BookDTO> createBook(@RequestBody Book book)
            {
                return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
            }

        @PutMapping("/{id}")
        public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody Book updatedBook)
            {
                return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
            }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteAuthor(@PathVariable Long id)
            {
                bookService.deleteBook(id);
                return ResponseEntity.ok("Author delete with related book");
            }

    }

