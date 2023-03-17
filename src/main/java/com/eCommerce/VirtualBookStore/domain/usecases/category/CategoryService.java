package com.eCommerce.VirtualBookStore.domain.usecases.category;

import com.eCommerce.VirtualBookStore.adapters.output.repositories.CategoryRepository;
import com.eCommerce.VirtualBookStore.adapters.output.response.CategoryResponse;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Transactional
    public Category performs(@Valid CategoryRequestData request) {
        Category category = request.toModel();
        categoryRepository.save(category);
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(category);
    }
}
