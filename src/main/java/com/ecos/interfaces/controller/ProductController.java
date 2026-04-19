package com.ecos.interfaces.controller;

import java.util.List;

import com.ecos.application.dto.request.ProductRequest;
import com.ecos.application.dto.response.ProductResponse;
import com.ecos.application.usecase.ProductUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        return ResponseEntity.ok(productUseCase.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {

        return ResponseEntity.ok(productUseCase.saveProduct(request));
    }

    @PostMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest request) {

        return ResponseEntity.ok(productUseCase.saveProduct(request));
    }

    @PostMapping("/delete")
    public ResponseEntity<ProductResponse> deleteProduct(@RequestBody ProductRequest request) {

        return ResponseEntity.ok(productUseCase.deleteProduct(request));
    }

}
