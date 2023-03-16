package com.eCommerce.VirtualBookStore.adapters.output.response;

import com.eCommerce.VirtualBookStore.domain.entities.Order;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderResponse {

    private BigDecimal total;
    private BigDecimal totalWithDiscount;
    private Set<OrderItemResponse> items = new HashSet<>();

    public OrderResponse(Order order) {
        this.total = order.getTotal();
        this.totalWithDiscount = order.getTotalWithDiscount();
        this.items = order.getItems().stream().map(OrderItemResponse::new).collect(Collectors.toSet());
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public Set<OrderItemResponse> getItems() {
        return items;
    }
}
