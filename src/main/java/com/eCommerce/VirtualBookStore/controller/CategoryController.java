package com.eCommerce.VirtualBookStore.controller;

import com.eCommerce.VirtualBookStore.model.entities.Category;
import com.eCommerce.VirtualBookStore.model.entitiesRequest.CategoryRequest;
import com.eCommerce.VirtualBookStore.model.entitiesResponse.CategoryResponse;
import com.eCommerce.VirtualBookStore.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping(value = "/categories")
    public ResponseEntity<?> createCategory (@RequestBody @Valid CategoryRequest request) {
        Category category = request.toModel();
        service.createCategory(category);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.ok(categoryResponse);
    }

}
