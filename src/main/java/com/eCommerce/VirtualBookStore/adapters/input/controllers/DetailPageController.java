package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.output.response.BookResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.usecases.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailPageController {

    @Autowired
    private BookService service;

    @GetMapping(value = "products/{id}")
    public ResponseEntity<?> bookDetails(@PathVariable Long id) {

        Book bookSearch = service.findById(id);
        BookResponse bookResponse = new BookResponse(bookSearch);

        return ResponseEntity.ok(bookResponse);

    }

}
