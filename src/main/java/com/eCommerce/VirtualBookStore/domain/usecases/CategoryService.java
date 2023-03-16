package com.eCommerce.VirtualBookStore.domain.usecases;

import com.eCommerce.VirtualBookStore.adapters.input.request.category.CategoryRequest;
import com.eCommerce.VirtualBookStore.adapters.output.repositories.CategoryRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.CategoryResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category performs(CategoryRequest request) {
        Category category = request.toModel();
        categoryRepository.save(category);
        return category;
    }

    public CategoryResponse toResponse (Category category) {
        return new CategoryResponse(category);
    }
}
