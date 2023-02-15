package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Book;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.BookRequest;
import com.eCommerce.VirtualBookStore.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/books")
    public ResponseEntity<Book> createBook (@RequestBody @Valid BookRequest request) {
        Book book = request.toModel(manager);
        service.createBook(book);
        return ResponseEntity.ok().body(book);
    }


}
