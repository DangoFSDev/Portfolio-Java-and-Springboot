package com.ecos.domain.model;

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
    private Double price;
    private Boolean isActive;
    private Integer stock;

}
