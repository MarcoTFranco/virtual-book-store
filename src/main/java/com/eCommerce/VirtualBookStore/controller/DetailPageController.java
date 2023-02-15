package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Book;
import com.eCommerce.VirtualBookStore.model.entitiesResponse.BookResponse;
import com.eCommerce.VirtualBookStore.service.BookService;
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
    public ResponseEntity<BookResponse> bookDetails (@PathVariable Long id){

        Book bookSearch = service.findById(id);
        BookResponse bookResponse = new BookResponse(bookSearch);

        if (bookResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookResponse);

    }

}
