package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Category;
import com.eCommerce.VirtualBookStore.service.annotations.DuplicateValue;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank
    @DuplicateValue(className = Category.class, fieldName = "name")
    private String name;

    @Deprecated
    public CategoryRequest() {
    }

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toModel() {
        return new Category(name);
    }
}
