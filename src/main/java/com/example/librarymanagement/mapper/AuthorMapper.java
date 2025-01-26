package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dao.Author;
import com.example.librarymanagement.model.dto.AuthorDTO;

public class AuthorMapper {
    public static AuthorDTO toAuthorDTO(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        dto.setBio(author.getBio());
        dto.setDob(author.getDob());
        return dto;
    }

    public static Author toAuthor(AuthorDTO dto) {
        if (dto == null) {
            return null;
        }

        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        return author;
    }
}
