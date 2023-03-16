package com.eCommerce.VirtualBookStore.domain.usecases;

import com.eCommerce.VirtualBookStore.adapters.input.request.author.AuthorData;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.AuthorRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.AuthorResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Author;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author performs(@Valid AuthorData data) {
        Author author = data.toModel();
        authorRepository.save(author);
        return author;
    }

    public AuthorResponse toResponse(Author author) {
        return new AuthorResponse(author);
    }
}
