package com.ecos.infrastructure.repository;

import java.util.Optional;

import com.ecos.infrastructure.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByCode(String code);

}
