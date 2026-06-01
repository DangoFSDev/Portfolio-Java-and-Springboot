package com.ecos.application.usecase;

import java.util.List;

import com.ecos.application.dto.request.OrderRequest;
import com.ecos.application.dto.response.OrderResponse;
import com.ecos.domain.model.Order;
import com.ecos.domain.repository.OrderRepository;
import com.ecos.infrastructure.entity.OrderEntity;
import com.ecos.infrastructure.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderUseCase {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    // TODO: implementation
    public List<OrderResponse> getAllOrders(Long userId) {

        List<OrderEntity> orders = orderRepository.getAllOrdersByUserId(userId);
        return orders.stream()
                     .map(orderMapper::toResponse)
                     .toList();
    }

    public List<OrderResponse> addOrder(List<OrderRequest> requests) {

        List<Order> orders = requests.stream()
                                     .map(orderMapper::toDomain)
                                     .toList();
        List<OrderEntity> savedOrders = orderRepository.addOrders(orders);
        return savedOrders.stream()
                          .map(orderMapper::toResponse)
                          .toList();
    }

    public OrderResponse updateOrderQuantity(OrderRequest request) {

        Order order = orderMapper.toDomain(request);
        OrderEntity updatedOrder = orderRepository.updateOrderQuantity(order);
        return orderMapper.toResponse(updatedOrder);
    }

    public OrderResponse deleteOrder(OrderRequest request) {

        Order order = orderMapper.toDomain(request);
        orderRepository.deleteOrder(order);
        return null; // TODO: return something meaningful, maybe a success message or the deleted order details
    }

    public void deleteAllOrders(List<OrderRequest> requests) {

        List<Order> orders = requests.stream()
                                     .map(orderMapper::toDomain)
                                     .toList();
        orderRepository.deleteAllOrders(orders);
    }

}
