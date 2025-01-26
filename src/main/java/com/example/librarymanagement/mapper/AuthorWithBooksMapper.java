package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dao.Author;
import com.example.librarymanagement.model.dao.Book;
import com.example.librarymanagement.model.dto.AuthorWithBooksDTO;
import com.example.librarymanagement.model.dto.BookDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorWithBooksMapper
    {
        public static AuthorWithBooksDTO toAuthorWithBooksDTO(Author author)
            {
                if (author == null)
                    {
                        return null;
                    }

                AuthorWithBooksDTO dto = new AuthorWithBooksDTO();
                dto.setId(author.getId());
                dto.setName(author.getName());
                dto.setBio(author.getBio());
                dto.setEmail(author.getEmail());
                dto.setDob(author.getDob());
                List<BookDTO> bookDTOs = author.getBooks().stream().map(BookMapper::toBookDTO).collect(Collectors.toList());
                dto.setBooks(bookDTOs);
                return dto;
            }

        public static Author toAuthor(AuthorWithBooksDTO dto)
            {
                if (dto == null)
                    {
                        return null;
                    }

                Author author = new Author();
                author.setId(dto.getId());
                author.setName(dto.getName());
                author.setBio(dto.getBio());
                author.setEmail(dto.getEmail());
                author.setDob(dto.getDob());

                List<Book> books = dto.getBooks().stream().map(BookMapper::toBook).collect(Collectors.toList());
                author.setBooks(books);
                return author;
            }
    }

