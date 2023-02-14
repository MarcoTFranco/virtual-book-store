package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Author;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.AuthorRequest;
import com.eCommerce.VirtualBookStore.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService service;

    @PostMapping(value = "/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid AuthorRequest request) {
        Author author = request.toModel();
        service.createAuthor(author);
        return ResponseEntity.ok().body(author);
    }

}
