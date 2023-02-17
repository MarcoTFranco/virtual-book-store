package com.eCommerce.VirtualBookStore.model.entitiesRequest;

import com.eCommerce.VirtualBookStore.model.entities.Book;
import com.eCommerce.VirtualBookStore.model.entities.OrderItem;
import com.eCommerce.VirtualBookStore.service.annotations.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderItemRequest {
    @NotNull
    @ExistId(className = Book.class)
    private Long bookId;
    @Positive
    private Integer amount;

    public OrderItemRequest(Long bookId, Integer amount) {
        this.bookId = bookId;
        this.amount = amount;
    }


    public OrderItem toModel(EntityManager manager) {
        @NotNull Book book = manager.find(Book.class, bookId);
        return new OrderItem(book, amount);
    }
}
