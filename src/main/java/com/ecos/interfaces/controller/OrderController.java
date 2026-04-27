package com.ecos.interfaces.controller;

import java.util.List;

import com.ecos.application.dto.request.CheckoutRequest;
import com.ecos.application.dto.request.OrderRequest;
import com.ecos.application.dto.request.PaymentRequest;
import com.ecos.application.dto.response.OrderResponse;
import com.ecos.application.dto.response.PaymentResponse;
import com.ecos.application.usecase.CheckoutUseCase;
import com.ecos.application.usecase.OrderUseCase;
import com.ecos.common.enums.PaymentType;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    private final OrderUseCase orderUseCase;

    @PostMapping("/checkout")
    public ResponseEntity<OrderResponse> checkout(@RequestBody CheckoutRequest request) {

        return ResponseEntity.ok(checkoutUseCase.saveOrder(request));
    }

    @PostMapping("/payment/{paymentType}")
    public ResponseEntity<PaymentResponse> checkout(@RequestBody PaymentRequest request,
            @PathVariable("paymentType") PaymentType paymentType) {

        return ResponseEntity.ok(checkoutUseCase.processPayment(paymentType, request));
    }

    @GetMapping("/getAllOrders/{userId}")
    public ResponseEntity<List<OrderResponse>> getAllOrders(@PathVariable("userId") Long userId) {

        return ResponseEntity.ok(orderUseCase.getAllOrders(userId));
    }

    @PostMapping("/addOrder")
    public ResponseEntity<List<OrderResponse>> addOrder(@RequestBody List<OrderRequest> requests) {

        return ResponseEntity.ok(orderUseCase.addOrder(requests));
    }

    @PatchMapping("/updateOrderQuantity")
    public ResponseEntity<OrderResponse> updateOrderQuantity(@RequestBody OrderRequest request) {

        return ResponseEntity.ok(orderUseCase.updateOrderQuantity(request));
    }

    @DeleteMapping("/deleteOrder")
    public ResponseEntity<OrderResponse> deleteOrder(@RequestBody OrderRequest request) {

        return ResponseEntity.ok(orderUseCase.deleteOrder(request));
    }

    @DeleteMapping("/deleteAllOrders")
    public ResponseEntity<List<OrderResponse>> deleteAllOrders(@RequestBody List<OrderRequest> requests) {

        return ResponseEntity.ok(orderUseCase.deleteAllOrders(requests));
    }

}
