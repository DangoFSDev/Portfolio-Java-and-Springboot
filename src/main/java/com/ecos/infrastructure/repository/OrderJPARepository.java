package com.ecos.infrastructure.repository;

import java.util.List;

import com.ecos.infrastructure.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJPARepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserId(Long userId);

    default OrderEntity updateQuantity(Long orderId, Integer quantity) {

        OrderEntity order = findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setQuantity(quantity);
        return save(order);
    }

}
