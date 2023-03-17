package com.eCommerce.VirtualBookStore.adapters.input.controllers;

import com.eCommerce.VirtualBookStore.adapters.input.request.category.CategoryRequest;
import com.eCommerce.VirtualBookStore.adapters.output.response.CategoryResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import com.eCommerce.VirtualBookStore.domain.usecases.category.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/categories")
    public ResponseEntity<CategoryResponse> createCategory (@RequestBody @Valid CategoryRequest request) {
        Category category = categoryService.performs(request);
        return ResponseEntity.ok(categoryService.toResponse(category));
    }

}
