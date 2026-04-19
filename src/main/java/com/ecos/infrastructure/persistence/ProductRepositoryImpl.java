package com.ecos.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.ecos.domain.model.Product;
import com.ecos.domain.repository.ProductRepository;
import com.ecos.infrastructure.mapper.ProductMapper;
import com.ecos.infrastructure.repository.ProductJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJPARepository jpaRepository;
    private final ProductMapper mapper;

    @Override
    public Optional<Product> findById(Long id) {

        return jpaRepository.findById(id)
                            .map(mapper::toDomain);
    }

    @Override
    @Transactional
    public Product save(Product product) {

        // TODO: Check if the code is already existing in the database, if exist, throw exception
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(product))
        );
    }

    @Override
    public List<Product> getAllProducts() {

        return mapper.toDomainList(jpaRepository.findAll());
    }

}
