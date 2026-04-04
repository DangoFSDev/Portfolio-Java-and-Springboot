package com.ecos.domain.model;

import java.util.List;

import com.ecos.common.enums.OrderStatus;
import com.ecos.domain.exception.DomainException;
import com.ecos.domain.valueobjects.Money;

import lombok.Getter;

@Getter
public class Order {

    private final List<OrderItem> items;
    private final Money total;
    private Long id;
    private OrderStatus status;

    public Order(List<OrderItem> items) {

        this.items = List.copyOf(items);
        this.total = calculateTotal();
        this.status = OrderStatus.PENDING;
    }

    public Order(List<OrderItem> items, Money total, Long id) {

        this.items = List.copyOf(items);
        this.total = total;
        this.status = OrderStatus.PENDING;
        this.id = id;
    }

    public List<OrderItem> getItems() {

        return List.copyOf(items);
    }

    private Money calculateTotal() {

        return items.stream()
                    .map(OrderItem::getSubtotal)
                    .reduce(Money.zero(), Money::add);
    }

    public void confirm() {

        if (items.isEmpty()) {
            throw new DomainException("Order must have items");
        }
        this.status = OrderStatus.CONFIRMED;
    }

}
