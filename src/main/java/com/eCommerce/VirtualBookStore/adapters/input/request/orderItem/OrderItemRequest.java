package com.eCommerce.VirtualBookStore.adapters.input.request.orderItem;

import com.eCommerce.VirtualBookStore.domain.entities.Book;
import com.eCommerce.VirtualBookStore.domain.entities.OrderItem;
import com.eCommerce.VirtualBookStore.domain.usecases.annotations.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderItemRequest {
    @NotNull
    @ExistId(className = Book.class)
    private Long bookId;
    @Positive
    private Integer amount;

    public OrderItemRequest( @NotNull Long bookId, @Positive Integer amount) {
        this.bookId = bookId;
        this.amount = amount;
    }

    public OrderItem toModel(EntityManager manager) {
        @NotNull Book book = manager.find(Book.class, bookId);
        return new OrderItem(book, amount);
    }
}
