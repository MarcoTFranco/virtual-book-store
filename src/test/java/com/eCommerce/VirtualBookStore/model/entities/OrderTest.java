package com.eCommerce.VirtualBookStore.model.entities;

import com.eCommerce.VirtualBookStore.domain.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

class OrderTest {

    @ParameterizedTest
    @DisplayName("verificar total do pedido")
    @CsvSource({"10.0,true", "9.99,false", "10.01,false"})
    void test1(BigDecimal value, boolean expectedResult) throws Exception {

        Author author = new Author("nome", "nome@gmail.com", "description");
        Category category = new Category("category");
        Book book = new Book("title", "summary", "summaryFree",
                BigDecimal.TEN, 100, "1233456789",
                LocalDate.of(2000, 1, 1), category, author);
        Set<OrderItem> itens = Set.of(new OrderItem(book, 1));
        Order order = new Order(Mockito.mock(Payment.class), itens);

        Assertions.assertEquals(expectedResult, order.totalEquals(value));

    }

}