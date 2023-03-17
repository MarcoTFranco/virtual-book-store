package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.book.BookRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.BookResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.usecases.book.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody @Valid BookRequest request) {
        Book book = bookService.performs(request);
        return ResponseEntity.ok(bookService.toResponse(book));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(bookService.toListResponse(books));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(bookService.toResponse(book));
    }
}
