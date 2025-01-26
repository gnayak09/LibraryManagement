package com.example.librarymanagement.repositories;

import com.example.librarymanagement.model.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
    {
    }
