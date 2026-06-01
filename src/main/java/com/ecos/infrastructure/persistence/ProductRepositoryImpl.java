package com.ecos.infrastructure.persistence;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.ecos.domain.model.Product;
import com.ecos.domain.repository.ProductRepository;
import com.ecos.infrastructure.exception.DatabaseException;
import com.ecos.infrastructure.exception.RecordNotFoundException;
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

        Product existingCode = findByCode(product.getCode())
                .orElse(null);

        if (existingCode != null && !Objects.equals(product.getId(), existingCode.getId())) {
            throw new DatabaseException("Product Code already exists!");
        }

        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(product))
        );
    }

    @Override
    public List<Product> getAllProducts() {

        return mapper.toDomainList(jpaRepository.findAll());
    }

    @Override
    public int delete(Product product) {

        Product existingProduct = findById(product.getId()).orElse(null);
        if (existingProduct == null) {
            throw new RecordNotFoundException("Product not found with id: " + product.getId());
        }

        try {
            jpaRepository.delete(mapper.toEntity(existingProduct));

            Product checkProduct = findById(existingProduct.getId()).orElse(null);
            if (checkProduct != null) {
                throw new DatabaseException("Failed to delete product with id: " + product.getId());
            } else {
                return 0; // Indicating successful deletion
            }
        } catch (Exception e) {
            throw new DatabaseException("Failed to delete product with id: " + product.getId(), e);
        }
    }

    @Override
    public Optional<Product> findByCode(String code) {

        return jpaRepository.findByCode(code)
                            .map(mapper::toDomain);
    }

}
