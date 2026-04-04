package com.ecos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecos.domain.model.Product;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> getAllProducts();

}
