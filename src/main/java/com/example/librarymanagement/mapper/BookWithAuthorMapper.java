package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dao.Author;
import com.example.librarymanagement.model.dao.Book;
import com.example.librarymanagement.model.dto.AuthorDTO;
import com.example.librarymanagement.model.dto.BookWithAuthorDTO;

public class BookWithAuthorMapper {
    public static BookWithAuthorDTO toBookWithAuthorDTO(Book book) {
        if (book == null) {
            return null;
        }

        BookWithAuthorDTO dto = new BookWithAuthorDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIsbn(book.getIsbn());
        dto.setCategory(book.getCategory());

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(book.getAuthor().getId());
        authorDTO.setName(book.getAuthor().getName());
        authorDTO.setEmail(book.getAuthor().getEmail());
        authorDTO.setBio(book.getAuthor().getBio());
        authorDTO.setDob(book.getAuthor().getDob());

        dto.setAuthor(authorDTO);

        return dto;
    }

    public static Book toBook(BookWithAuthorDTO dto) {
        if (dto == null) {
            return null;
        }

        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setCategory(dto.getCategory());

        Author author = new Author();
        author.setId(dto.getAuthor().getId());
        author.setName(dto.getAuthor().getName());
        author.setEmail(dto.getAuthor().getEmail());
        // Set other author fields as needed

        book.setAuthor(author);

        return book;
    }
}
