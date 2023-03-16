package com.eCommerce.VirtualBookStore.model.request;

import com.eCommerce.VirtualBookStore.adapters.input.request.book.BookRequest;
import com.eCommerce.VirtualBookStore.domain.entities.Author;
import com.eCommerce.VirtualBookStore.domain.entities.Category;
import com.eCommerce.VirtualBookStore.domain.usecases.BookService;
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

        BookService service = Mockito.mock(BookService.class);

        Mockito.when(service.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(service.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertNotNull(request.toModel(service));

    }

    @Test
    @DisplayName("Nao cria livro caso o autor nao exista no banco")
    void test2() {

        BookService service = Mockito.mock(BookService.class);

        Mockito.when(service.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(service.find(Author.class, 1L)).thenReturn(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            request.toModel(service);
        });

    }

    @Test
    @DisplayName("não cria livro caso a categoria nao exista")
    void test3() {

        BookService service = Mockito.mock(BookService.class);

        Mockito.when(service.find(Category.class, 1L)).thenReturn(null);
        Mockito.when(service.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertThrows(IllegalStateException.class, () -> {
            request.toModel(service);
        });
    }
}