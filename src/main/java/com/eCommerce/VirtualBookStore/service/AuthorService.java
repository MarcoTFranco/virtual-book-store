package com.eCommerce.VirtualBookStore.service;

import com.eCommerce.VirtualBookStore.model.entities.Author;
import com.eCommerce.VirtualBookStore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public void createAuthor(Author author){
        repository.save(author);
    }

}
