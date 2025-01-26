package com.example.librarymanagement.model.dto;

import com.example.librarymanagement.model.dao.Author;
import jakarta.persistence.*;

public class BookDTO
    {

        private Long id;

        private String title;

        private String isbn;

        private String category;

        public Long getId()
            {
                return id;
            }

        public void setId(Long id)
            {
                this.id = id;
            }

        public String getTitle()
            {
                return title;
            }

        public void setTitle(String title)
            {
                this.title = title;
            }

        public String getIsbn()
            {
                return isbn;
            }

        public void setIsbn(String isbn)
            {
                this.isbn = isbn;
            }

        public String getCategory()
            {
                return category;
            }

        public void setCategory(String category)
            {
                this.category = category;
            }


    }
