package com.ecos.application.usecase;

import java.util.List;

import com.ecos.application.dto.request.ProductRequest;
import com.ecos.application.dto.response.ProductResponse;
import com.ecos.domain.exception.DomainException;
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
                          .filter(product -> product.getStock() > 0 && product.getIsActive())
                          .map(productMapper::toResponse)
                          .toList();
    }

    public ProductResponse saveProduct(ProductRequest request) {

        return ProductResponse.builder()
                              .product(productRepository.save(productMapper.toDomain(request)))
                              .build();
    }

    public ProductResponse deleteProduct(ProductRequest request) {

        int result = productRepository.delete(productMapper.toDomain(request));

        if (result == 1) {
            throw new DomainException("Failed to delete product with id: " + request.getId());
        } else {
            return ProductResponse.builder()
                                  .message("Product id " + request.getId() + " has been successfully deleted.")
                                  .status("success")
                                  .build();
        }
    }

}
