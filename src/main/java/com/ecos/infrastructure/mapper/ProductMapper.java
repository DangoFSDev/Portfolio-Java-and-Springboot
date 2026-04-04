package com.ecos.infrastructure.mapper;

import java.util.List;

import com.ecos.application.dto.response.ProductResponse;
import com.ecos.domain.model.Product;
import com.ecos.infrastructure.entity.ProductEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

    List<Product> toDomainList(List<ProductEntity> productEntity);

    ProductResponse toResponse(Product product);

}
