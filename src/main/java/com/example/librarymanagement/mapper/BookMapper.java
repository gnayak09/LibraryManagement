package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dao.Book;
import com.example.librarymanagement.model.dto.BookDTO;

public class BookMapper
    {
        public static BookDTO toBookDTO(Book book)
            {
                if (book == null)
                    {
                        return null;
                    }

                BookDTO bookDTO = new BookDTO();
                bookDTO.setId(book.getId());
                bookDTO.setTitle(book.getTitle());
                bookDTO.setIsbn(book.getIsbn());
                bookDTO.setCategory(book.getCategory());
                return bookDTO;
            }

        public static Book toBook(BookDTO bookDTO)
            {
                if (bookDTO == null)
                    {
                        return null;
                    }

                Book book = new Book();
                book.setId(bookDTO.getId());
                book.setTitle(bookDTO.getTitle());
                book.setIsbn(bookDTO.getIsbn());
                book.setCategory(bookDTO.getCategory());
                return book;
            }
    }

