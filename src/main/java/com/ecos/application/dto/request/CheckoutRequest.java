package com.ecos.application.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class CheckoutRequest {

    List<CheckoutItem> items;

    public CheckoutRequest(List<CheckoutItem> items) {

        this.items = List.copyOf(items);
    }

    public List<CheckoutItem> getItems() {

        return List.copyOf(items);
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class CheckoutItem {

        private Long productId;
        private Integer quantity;
        private Double price;

    }

}
