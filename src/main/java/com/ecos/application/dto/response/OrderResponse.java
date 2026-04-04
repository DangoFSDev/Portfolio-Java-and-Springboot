package com.ecos.application.dto.response;

import com.ecos.domain.valueobjects.Money;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OrderResponse {

    private Long orderId;
    private Money total;

}
