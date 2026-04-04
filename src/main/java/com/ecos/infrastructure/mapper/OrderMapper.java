package com.ecos.infrastructure.mapper;

import com.ecos.domain.model.Order;
import com.ecos.infrastructure.entity.OrderEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);

}
