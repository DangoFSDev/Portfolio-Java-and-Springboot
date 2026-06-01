package com.ecos.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OrderResponse {

    private Long id;
    private String code;
    private Double total;
    private Integer quantity;

}
