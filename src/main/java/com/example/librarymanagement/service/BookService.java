package com.example.librarymanagement.service;

import com.example.librarymanagement.excetion.AuthorNotFoundException;
import com.example.librarymanagement.excetion.BookNotFoundException;
import com.example.librarymanagement.mapper.BookMapper;
import com.example.librarymanagement.model.dao.Book;
import com.example.librarymanagement.model.dto.BookDTO;
import com.example.librarymanagement.repositories.AuthorRepository;
import com.example.librarymanagement.repositories.BookRepository;
import com.example.librarymanagement.service.async.KafkaProducer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService
    {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private KafkaProducer kafkaProducer;

        @Autowired
        private AuthorRepository authorRepository;

        @Value("${kafka.topic.book}")
        private String bookTopic;

        public BookDTO getBookById(Long id)
            {
                Optional<Book> book = bookRepository.findById(id);
                if (book.isPresent())
                    {
                        return BookMapper.toBookDTO(book.get());
                    }
                throw new BookNotFoundException("Book not found with id : " + id);
            }


        public List<BookDTO> getAllBooks()
            {
                return bookRepository.findAll().stream().map(BookMapper::toBookDTO).collect(Collectors.toList());
            }


        public BookDTO saveBook(Book book)
            {
                if (!authorRepository.existsById(book.getAuthor().getId()))
                    {
                        throw new AuthorNotFoundException("Author not found with id : " + book.getAuthor().getId());
                    }
                kafkaProducer.sendMessage(bookTopic, "Book created: " + book.getId());
                return BookMapper.toBookDTO(bookRepository.save(book));
            }

        @Transactional
        public BookDTO updateBook(Long id, Book updatedBook)
            {
                return bookRepository.findById(id).map(book ->
                    {
                        book.setTitle(updatedBook.getTitle());
                        book.setIsbn(updatedBook.getIsbn());
                        book.setCategory(updatedBook.getCategory());
                        if (!authorRepository.existsById(book.getAuthor().getId()))
                            {
                                throw new AuthorNotFoundException("Author not found with  id : " + book.getAuthor().getId());
                            }
                        book.setAuthor(updatedBook.getAuthor());
                        kafkaProducer.sendMessage(bookTopic, "Book updated: " + book.getId());
                        return BookMapper.toBookDTO(bookRepository.save(book));
                    }).orElseThrow(() -> new BookNotFoundException("Book not found with id : " + id));

            }

        public void deleteBook(Long id)
            {
                if (!bookRepository.existsById(id))
                    {
                        throw new BookNotFoundException("Book not exist");
                    }
                kafkaProducer.sendMessage(bookTopic, "Book deleted: " + id);
                bookRepository.deleteById(id);
            }
    }