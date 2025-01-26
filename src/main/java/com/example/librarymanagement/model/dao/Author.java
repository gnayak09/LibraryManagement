package com.example.librarymanagement.model.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Author
    {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = true, length = 1000)
        private String bio;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = true)
        private LocalDate dob;

        @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Book> books;

        public Long getId()
            {
                return id;
            }

        public void setId(Long id)
            {
                this.id = id;
            }

        public String getName()
            {
                return name;
            }

        public void setName(String name)
            {
                this.name = name;
            }

        public String getBio()
            {
                return bio;
            }

        public void setBio(String bio)
            {
                this.bio = bio;
            }

        public String getEmail()
            {
                return email;
            }

        public void setEmail(String email)
            {
                this.email = email;
            }

        public LocalDate getDob()
            {
                return dob;
            }

        public void setDob(LocalDate dob)
            {
                this.dob = dob;
            }

        public List<Book> getBooks()
            {
                return books;
            }

        public void setBooks(List<Book> books)
            {
                this.books = books;
            }
    }
