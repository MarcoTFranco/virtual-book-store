package com.eCommerce.VirtualBookStore.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class OrderItem {
    @JsonIgnore
    @NotNull
    @ManyToOne
    private Book book;
    @Positive
    private Integer amount;
    @Positive
    private BigDecimal momentPrice;

    @Deprecated
    public OrderItem() {
    }

    public OrderItem(@NotNull Book book, @Positive Integer amount) {
        this.book = book;
        this.amount = amount;
        this.momentPrice = book.getPrice();
    }

    public Book getBook() {
        return book;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigDecimal getMomentPrice() {
        return momentPrice;
    }

    public BigDecimal total() {
        return momentPrice.multiply(BigDecimal.valueOf(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(book, orderItem.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}


