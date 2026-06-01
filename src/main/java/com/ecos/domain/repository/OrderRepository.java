package com.ecos.domain.repository;

import java.util.List;

import com.ecos.domain.model.Order;
import com.ecos.infrastructure.entity.OrderEntity;

public interface OrderRepository {

    OrderEntity save(Order order);

    List<OrderEntity> getAllOrdersByUserId(Long userId);

    List<OrderEntity> addOrders(List<Order> orders);

    OrderEntity updateOrderQuantity(Order order);

    void deleteOrder(Order order);

    void deleteAllOrders(List<Order> orders);

}
