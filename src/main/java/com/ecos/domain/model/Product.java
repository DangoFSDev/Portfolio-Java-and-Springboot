package com.ecos.domain.model;

import com.ecos.domain.exception.DomainException;
import com.ecos.domain.valueobjects.Money;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Product {

    private Long id;
    private String code;
    private String name;
    private Money price;
    private boolean isActive;
    private int stock;

    public void decreaseStock(int qty) {

        if (stock < qty) {
            throw new DomainException("Insufficient stock");
        }
        stock -= qty;
    }

}
