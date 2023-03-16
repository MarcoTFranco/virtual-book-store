package com.eCommerce.VirtualBookStore.adapters.output.response;

import com.eCommerce.VirtualBookStore.domain.entities.Author;

public class AuthorResponse {
    private String name;
    private String description;

    public AuthorResponse(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
