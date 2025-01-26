package com.example.librarymanagement.model.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;

public class AuthorDTO
    {

        private Long id;

        private String name;

        private String bio;

        private String email;

        private LocalDate dob;

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


    }
