package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Book;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.BookRequest;
import com.eCommerce.VirtualBookStore.model.entitiesResponse.BookResponse;
import com.eCommerce.VirtualBookStore.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/books")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest request) {
        Book book = request.toModel(manager);
        service.createBook(book);
        BookResponse bookResponse = new BookResponse(book);
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping(value = "/books/all")
    public ResponseEntity<List<?>> findAll() {
        List<Book> books = service.findAll();
        List<BookResponse> booksResponse = books.stream().map(BookResponse::new).toList();
        return ResponseEntity.ok(booksResponse);
    }
}
