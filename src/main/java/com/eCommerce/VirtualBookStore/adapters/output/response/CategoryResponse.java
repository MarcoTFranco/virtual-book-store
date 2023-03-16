package com.eCommerce.VirtualBookStore.adapters.output.response;

import com.eCommerce.VirtualBookStore.domain.entities.Category;

public class CategoryResponse {
    private String name;

    public CategoryResponse(Category category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }
}
