package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.book.BookRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.BookResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.usecases.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest request) {
        Book book = request.toModel(service);
        service.insert(book);
        BookResponse bookResponse = new BookResponse(book);
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<Book> books = service.findAll();
        List<BookResponse> booksResponse = books.stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(booksResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Book book = service.findById(id);
        BookResponse bookResponse = new BookResponse(book);
        return ResponseEntity.ok(bookResponse);
    }
}
