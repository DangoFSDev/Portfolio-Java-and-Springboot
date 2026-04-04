package com.ecos.domain.model;

import com.ecos.domain.valueobjects.Money;
import com.ecos.domain.valueobjects.Quantity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OrderItem {

    private Long productId;
    private Quantity quantity;
    private Money price;

    public Money getSubtotal() {

        return price.multiply(quantity.value());
    }

}
