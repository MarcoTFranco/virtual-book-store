package com.eCommerce.VirtualBookStore.adapters.input.request;

import com.eCommerce.VirtualBookStore.domain.entities.Category;
import com.eCommerce.VirtualBookStore.domain.service.annotations.DuplicateValue;
import com.eCommerce.VirtualBookStore.domain.service.category.CategoryRequestData;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest implements CategoryRequestData {
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

    @Override
    public Category toModel() {
        return new Category(name);
    }
}
