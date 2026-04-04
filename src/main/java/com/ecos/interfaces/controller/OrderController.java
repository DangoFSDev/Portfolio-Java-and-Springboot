package com.ecos.interfaces.controller;

import com.ecos.application.dto.request.CheckoutRequest;
import com.ecos.application.dto.request.PaymentRequest;
import com.ecos.application.dto.response.OrderResponse;
import com.ecos.application.dto.response.PaymentResponse;
import com.ecos.application.usecase.CheckoutUseCase;
import com.ecos.common.enums.PaymentType;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CheckoutUseCase checkoutUseCase;

    @PostMapping("/checkout")
    public ResponseEntity<OrderResponse> checkout(@RequestBody CheckoutRequest request) {

        return ResponseEntity.ok(checkoutUseCase.saveOrder(request));
    }

    @PostMapping("/payment/{paymentType}")
    public ResponseEntity<PaymentResponse> checkout(@RequestBody PaymentRequest request,
            @PathVariable("paymentType") PaymentType paymentType) {

        return ResponseEntity.ok(checkoutUseCase.processPayment(paymentType, request));
    }

}
