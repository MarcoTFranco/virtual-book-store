package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.Category;

public class CategoryResponse {
    private String name;

    public CategoryResponse(Category category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }
}
