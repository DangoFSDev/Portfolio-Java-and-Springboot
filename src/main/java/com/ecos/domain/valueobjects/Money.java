package com.ecos.domain.valueobjects;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Money {

    private BigDecimal amount;

    public static Money zero() {

        return new Money(BigDecimal.ZERO);
    }

    public Money add(Money other) {

        return new Money(this.amount.add(other.amount));
    }

    public Money multiply(int qty) {

        return new Money(this.amount.multiply(BigDecimal.valueOf(qty)));
    }

}
