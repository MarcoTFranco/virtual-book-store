package com.eCommerce.VirtualBookStore.model.entitiesResponse;

import com.eCommerce.VirtualBookStore.model.entities.OrderItem;

import java.math.BigDecimal;

public class OrderItemResponse {

    private BookResponse book;
    private Integer amount;
    private BigDecimal momentPrice;

    public OrderItemResponse(OrderItem orderItem) {
        this.book = new BookResponse(orderItem.getBook());
        this.amount = orderItem.getAmount();
        this.momentPrice = orderItem.getMomentPrice();
    }

    public BookResponse getBook() {
        return book;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigDecimal getMomentPrice() {
        return momentPrice;
    }
}
