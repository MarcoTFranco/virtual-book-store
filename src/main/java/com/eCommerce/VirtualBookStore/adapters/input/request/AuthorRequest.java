package com.eCommerce.VirtualBookStore.adapters.input.request;

import com.eCommerce.VirtualBookStore.domain.entities.Author;
import com.eCommerce.VirtualBookStore.domain.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.service.author.AuthorRequestData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorRequest implements AuthorRequestData {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    @DuplicateValue(className = Author.class, fieldName = "email")
    private String email;
    @Size(max = 400)
    private String description;

    public AuthorRequest(@NotBlank String name, @NotBlank @Email String email,
                         @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Author toModel() {
        return new Author(name, email, description);
    }
}

