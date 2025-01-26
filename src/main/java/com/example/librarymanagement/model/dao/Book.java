package com.example.librarymanagement.model.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "book")

public class Book
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String isbn;

        @Column(nullable = false)
        private String category;

        @ManyToOne
        @JoinColumn(name = "author_id")
        private Author author;

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

        public Author getAuthor()
            {
                return author;
            }

        public void setAuthor(Author author)
            {
                this.author = author;
            }
    }
