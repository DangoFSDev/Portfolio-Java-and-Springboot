package com.ecos.application.usecase;

import java.util.List;

import com.ecos.application.dto.response.ProductResponse;
import com.ecos.domain.model.Product;
import com.ecos.domain.repository.ProductRepository;
import com.ecos.infrastructure.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts() {

        List<Product> productList = productRepository.getAllProducts();

        return productList.stream()
                          .filter(product -> product.getStock() > 0 && product.isActive())
                          .map(productMapper::toResponse)
                          .toList();
    }

}
