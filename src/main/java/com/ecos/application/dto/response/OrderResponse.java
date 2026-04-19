package com.ecos.application.dto.response;

import com.ecos.domain.valueobjects.Money;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OrderResponse {

    // TODO: add fields
    private Long orderId;
    private Money total;

}
