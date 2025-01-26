package com.example.librarymanagement.service;

import com.example.librarymanagement.excetion.AuthorNotFoundException;
import com.example.librarymanagement.excetion.BookNotFoundException;
import com.example.librarymanagement.mapper.AuthorWithBooksMapper;
import com.example.librarymanagement.mapper.BookWithAuthorMapper;
import com.example.librarymanagement.model.dao.Author;
import com.example.librarymanagement.model.dao.Book;
import com.example.librarymanagement.model.dto.AuthorWithBooksDTO;
import com.example.librarymanagement.model.dto.BookWithAuthorDTO;
import com.example.librarymanagement.repositories.AuthorRepository;
import com.example.librarymanagement.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService
    {
        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private AuthorRepository authorRepository;


        public List<BookWithAuthorDTO> getAllBooksWithAuthors()
            {
                return bookRepository.findAll().stream().map(BookWithAuthorMapper::toBookWithAuthorDTO).toList();
            }

        public BookWithAuthorDTO getBookWithAuthorsByBookId(Long bookId)
            {
                Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found"));
                return BookWithAuthorMapper.toBookWithAuthorDTO(book);

            }


        public List<AuthorWithBooksDTO> getAuthorWithBooks()
            {
                return authorRepository.findAll().stream().map(AuthorWithBooksMapper::toAuthorWithBooksDTO).toList();
            }

        public AuthorWithBooksDTO getAuthorWithBooksByAuthorID(Long authorId)
            {
                Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
                return AuthorWithBooksMapper.toAuthorWithBooksDTO(author);
            }
    }
