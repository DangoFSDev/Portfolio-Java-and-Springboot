package com.ecos.infrastructure.mapper;

import java.util.List;

import com.ecos.application.dto.request.ProductRequest;
import com.ecos.application.dto.response.ProductResponse;
import com.ecos.domain.model.Product;
import com.ecos.infrastructure.entity.ProductEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "price", ignore = true)
    Product toDomain(ProductEntity productEntity);

    @Mapping(target = "price", ignore = true)
    ProductEntity toEntity(Product product);

    List<ProductEntity> toEntityList(List<Product> product);

    List<Product> toDomainList(List<ProductEntity> productEntity);

    ProductResponse toResponse(Product product);

    Product toDomain(ProductRequest request);

}
