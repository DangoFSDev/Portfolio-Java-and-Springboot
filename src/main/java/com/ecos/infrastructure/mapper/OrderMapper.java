package com.ecos.infrastructure.mapper;

import com.ecos.application.dto.request.OrderRequest;
import com.ecos.application.dto.response.OrderResponse;
import com.ecos.domain.model.Order;
import com.ecos.infrastructure.entity.OrderEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(OrderRequest request);

    OrderResponse toResponse(Order order);

    OrderResponse toResponse(OrderEntity order);

    OrderEntity toEntity(Order order);

}
