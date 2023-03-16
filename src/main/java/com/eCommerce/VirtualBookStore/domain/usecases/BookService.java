package com.eCommerce.VirtualBookStore.domain.usecases;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.BookRepository;
import com.eCommerce.VirtualBookStore.domain.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    @PersistenceContext
    private EntityManager manager;

    public void insert(Book book) {
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
       return repository.findById(id).orElseThrow();
    }

    public <T> T find (Class<T> classe, Long id) {
        return manager.find(classe, id);
    }
}
