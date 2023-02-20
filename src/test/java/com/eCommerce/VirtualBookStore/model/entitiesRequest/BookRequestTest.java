package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Author;
import com.eCommerce.VirtualBookStore.model.entities.Category;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

class BookRequestTest {

    private BookRequest request = new BookRequest("", "", "",
            BigDecimal.TEN, 100, "", LocalDate.now(), 1L, 1L);
    @Test
    @DisplayName("criar o livro categoria e autor estao cadastrados")
    void teste1() throws  Exception {

        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(manager.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertNotNull(request.toModel(manager));

    }

    @Test
    @DisplayName("Nao cria livro caso o autor nao exista no banco")
    void test2() throws Exception {

        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(manager.find(Author.class, 1L)).thenReturn(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {request.toModel(manager);});

    }

    @Test
    @DisplayName("não cria livro caso a categoria nao exista")
    void test3() throws Exception {

        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Category.class, 1L)).thenReturn(null);
        Mockito.when(manager.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertThrows(IllegalStateException.class, () -> {request.toModel(manager);});
    }
}