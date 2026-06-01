package com.ecos.infrastructure.persistence;

import java.util.List;

import com.ecos.domain.model.Order;
import com.ecos.domain.repository.OrderRepository;
import com.ecos.infrastructure.entity.OrderEntity;
import com.ecos.infrastructure.mapper.OrderMapper;
import com.ecos.infrastructure.repository.OrderJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {


    private final OrderJPARepository jpaRepository;
    private final OrderMapper mapper;

    @Override
    public OrderEntity save(Order order) {

        OrderEntity entity = mapper.toEntity(order);
        return jpaRepository.save(entity);
    }

    @Override
    public List<OrderEntity> getAllOrdersByUserId(Long userId) {

        return jpaRepository.findByUserId(userId);
    }

    @Override
    public List<OrderEntity> addOrders(List<Order> orders) {

        List<OrderEntity> orderEntities = orders.stream()
                                                .map(mapper::toEntity)
                                                .toList();
        return jpaRepository.saveAll(orderEntities);
    }

    @Override
    public OrderEntity updateOrderQuantity(Order order) {

        OrderEntity entity = mapper.toEntity(order);
        return jpaRepository.updateQuantity(entity.getId(), entity.getQuantity());
    }

    @Override
    public void deleteOrder(Order order) {

        OrderEntity entity = mapper.toEntity(order);
        jpaRepository.deleteById(entity.getId());
    }

    @Override
    public void deleteAllOrders(List<Order> orders) {

        List<OrderEntity> orderEntities = orders.stream()
                                                .map(mapper::toEntity)
                                                .toList();
        jpaRepository.deleteAll(orderEntities);
    }

}
