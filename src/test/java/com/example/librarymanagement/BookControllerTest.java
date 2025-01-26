package com.example.librarymanagement;

import com.example.librarymanagement.controller.BookController;
import com.example.librarymanagement.excetion.BookNotFoundException;
import com.example.librarymanagement.model.dto.BookDTO;
import com.example.librarymanagement.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {


    @Mock
    private BookService service;

    @InjectMocks
    private BookController controller;
    ;

    @Test
    public void givenValidBookId_whenGetBookById_thenReturnBook() throws Exception {
        BookDTO book = new BookDTO();
        book.setId(1L);
        book.setCategory("Programming");
        book.setTitle("Effective Java");
        book.setIsbn("978-0134685991");
        Mockito.when(service.getBookById(1L)).thenReturn(book);
        ResponseEntity<BookDTO> resp = controller.getBookById(1l);
        Assertions.assertEquals("Programming", resp.getBody().getCategory());
        Assertions.assertTrue(resp.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void givenInValidBookId_whenGetBookById_thenReturnError(){}
    {
        MockitoAnnotations.openMocks(this);
        Mockito.when(service.getBookById(1L)).thenThrow(BookNotFoundException.class);
        Assertions.assertThrows(BookNotFoundException.class, ()-> controller.getBookById(1L));
    }
}
