package com.eCommerce.VirtualBookStore.service;

import com.eCommerce.VirtualBookStore.model.entities.Author;
import com.eCommerce.VirtualBookStore.model.entities.Book;
import com.eCommerce.VirtualBookStore.model.entities.Category;
import com.eCommerce.VirtualBookStore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void createBook(Book book) {
        repository.save(book);
    }
}
