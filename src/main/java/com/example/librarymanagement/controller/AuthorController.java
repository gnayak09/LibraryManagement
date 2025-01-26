package com.example.librarymanagement.controller;

import com.example.librarymanagement.excetion.AuthorNotFoundException;
import com.example.librarymanagement.model.dao.Author;
import com.example.librarymanagement.model.dto.AuthorDTO;
import com.example.librarymanagement.repositories.BookRepository;
import com.example.librarymanagement.repositories.AuthorRepository;
import com.example.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController
    {

        @Autowired
        private AuthorService authorService;


        @GetMapping
        public List<AuthorDTO> getAllAuthors()
            {
                return authorService.getAllAuthors();
            }

        @GetMapping("/{id}")
        public AuthorDTO getAuthorById(@PathVariable Long id)
            {
                return authorService.getAuthorById(id);
            }

        @PostMapping
        public AuthorDTO createAuthor(@RequestBody Author Author)
            {
                return authorService.saveAuthor(Author);
            }

        @PutMapping("/{id}")
        public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor)
            {
                return authorService.updateAuthor(id, updatedAuthor);
            }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteAuthor(@PathVariable Long id)
            {
                authorService.deleteAuthor(id);
                return ResponseEntity.ok().build();
            }
    }
