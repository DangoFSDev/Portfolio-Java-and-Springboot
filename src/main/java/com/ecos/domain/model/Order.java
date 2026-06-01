package com.ecos.domain.model;

import com.ecos.common.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Order {

    private String code;
    private Double total;
    private Long id;
    private OrderStatus status;

}
