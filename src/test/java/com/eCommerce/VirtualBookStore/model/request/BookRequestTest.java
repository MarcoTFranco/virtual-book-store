package com.eCommerce.VirtualBookStore.model.request;


import com.eCommerce.VirtualBookStore.adapters.input.request.BookRequest;
import com.eCommerce.VirtualBookStore.domain.entities.Author;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import com.eCommerce.VirtualBookStore.domain.service.findEntities.FindEntites;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

class BookRequestTest {

    private final BookRequest request = new BookRequest("", "", "",
            BigDecimal.TEN, 100, "", LocalDate.now(), 1L, 1L);

    @Test
    @DisplayName("criar o livro categoria e autor estao cadastrados")
    void teste1() {

        FindEntites service = Mockito.mock(FindEntites.class);

        Mockito.when(service.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(service.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertNotNull(
                request.toModel(
                authorId -> service.find(Author.class, authorId),
                categoryId -> service.find(Category.class, categoryId))
        );
    }

    @Test
    @DisplayName("Nao cria livro caso o autor nao exista no banco")
    void test2() {

        FindEntites service = Mockito.mock(FindEntites.class);

        Mockito.when(service.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(service.find(Author.class, 1L)).thenReturn(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            request.toModel(
                    authorId -> service.find(Author.class, authorId),
                    categoryId -> service.find(Category.class, categoryId));
        });

    }

    @Test
    @DisplayName("não cria livro caso a categoria nao exista")
    void test3() {

        FindEntites service = Mockito.mock(FindEntites.class);

        Mockito.when(service.find(Category.class, 1L)).thenReturn(null);
        Mockito.when(service.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertThrows(IllegalStateException.class, () -> {
            request.toModel(
                    authorId -> service.find(Author.class, authorId),
                    categoryId -> service.find(Category.class, categoryId));
        });
    }
}