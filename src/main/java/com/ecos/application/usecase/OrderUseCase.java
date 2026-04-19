package com.ecos.application.usecase;

import java.util.List;

import com.ecos.application.dto.request.OrderRequest;
import com.ecos.application.dto.response.OrderResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderUseCase {

    // TODO: implementation
    public List<OrderResponse> getAllOrders(Long userId) {

        return List.of();
    }

    public List<OrderResponse> addOrder(List<OrderRequest> requests) {

        return List.of();
    }

    public OrderResponse updateOrderQuantity(OrderRequest request) {

        return null;
    }

    public OrderResponse deleteOrder(OrderRequest request) {

        return null;
    }

    public List<OrderResponse> deleteAllOrders(List<OrderRequest> requests) {

        return List.of();
    }

}
