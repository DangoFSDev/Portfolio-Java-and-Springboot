package com.ecos.infrastructure.persistence;

import com.ecos.domain.model.Order;
import com.ecos.domain.repository.OrderRepository;
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
    public Order save(Order order) {

        return null;
    }

}
