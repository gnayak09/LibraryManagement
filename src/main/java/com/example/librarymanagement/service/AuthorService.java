package com.example.librarymanagement.service;

import com.example.librarymanagement.excetion.AuthorNotFoundException;
import com.example.librarymanagement.mapper.AuthorMapper;
import com.example.librarymanagement.model.dao.Author;
import com.example.librarymanagement.model.dto.AuthorDTO;
import com.example.librarymanagement.repositories.AuthorRepository;
import com.example.librarymanagement.service.async.KafkaProducer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService
    {

        @Autowired
        private AuthorRepository authorRepository;

        @Autowired
        private KafkaProducer kafkaProducer;
        
        @Value("${kafka.topic.author}")
        private String authorTopic;

        public List<AuthorDTO> getAllAuthors()
            {

                return authorRepository.findAll().stream().map(AuthorMapper::toAuthorDTO).toList();
            }

        public AuthorDTO getAuthorById(Long id)
            {
                Optional<Author> author = authorRepository.findById(id);
                if (author.isPresent())
                    {
                        return AuthorMapper.toAuthorDTO(author.get());
                    }
                throw new AuthorNotFoundException("Author not found with id : " + id);
            }

        public AuthorDTO saveAuthor(Author author)
            {
                kafkaProducer.sendMessage(authorTopic, "Author created: " + author.getId());
                return AuthorMapper.toAuthorDTO(authorRepository.save(author));
            }

        @Transactional
        public AuthorDTO updateAuthor(Long id, Author updatedAuthor)
            {

                return authorRepository.findById(id).map(author ->
                    {
                        author.setName(updatedAuthor.getName());
                        author.setBio(updatedAuthor.getBio());
                        author.setEmail(updatedAuthor.getEmail());
                        author.setDob(updatedAuthor.getDob());
                        kafkaProducer.sendMessage(authorTopic, "Author updated: " + author.getId());
                        return AuthorMapper.toAuthorDTO(authorRepository.save(author));
                    }).orElseThrow(() -> new AuthorNotFoundException("Author not found with id " + id));
            }

        public void deleteAuthor(Long id)
            {
                if (!authorRepository.existsById(id))
                    {
                        throw new AuthorNotFoundException("Author not found with id : " + id);
                    }
                kafkaProducer.sendMessage(authorTopic, "Author deleted: " + id);
                authorRepository.deleteById(id);
            }


    }
