package com.ecos.infrastructure.repository;

import com.ecos.infrastructure.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {

}
