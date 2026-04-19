package com.ecos.application.usecase;

import java.util.ArrayList;
import java.util.List;

import com.ecos.application.dto.request.CheckoutRequest;
import com.ecos.application.dto.request.CheckoutRequest.CheckoutItem;
import com.ecos.application.dto.request.PaymentRequest;
import com.ecos.application.dto.response.OrderResponse;
import com.ecos.application.dto.response.PaymentResponse;
import com.ecos.common.enums.PaymentType;
import com.ecos.domain.exception.DomainException;
import com.ecos.domain.model.Order;
import com.ecos.domain.model.OrderItem;
import com.ecos.domain.model.Product;
import com.ecos.domain.payment.PaymentOption;
import com.ecos.domain.payment.PaymentOptionFactory;
import com.ecos.domain.repository.OrderRepository;
import com.ecos.domain.repository.ProductRepository;
import com.ecos.domain.valueobjects.Quantity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutUseCase {

    private final PaymentOptionFactory paymentOptionFactory;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    /**
     * Save a new order based on the provided checkout request,
     * which includes a list of items to be purchased.
     * Each item is validated against the product repository to ensure availability and stock levels are updated accordingly.
     * The order is then created, confirmed, and saved to the order repository, returning an OrderResponse with the order ID
     * and total amount.
     *
     * @param request
     * @return
     */
    public OrderResponse saveOrder(CheckoutRequest request) {

        List<OrderItem> items = new ArrayList<>();

        for (CheckoutItem i : request.getItems()) {

            Product product = productRepository.findById(i.getProductId())
                                               .orElseThrow(() -> new DomainException("Product not found"));

            product.decreaseStock(i.getQuantity());

            items.add(new OrderItem(
                    product.getId(),
                    new Quantity(i.getQuantity()),
                    product.getPrice()
            ));
        }

        Order order = new Order(items);
        order.confirm();

        Order saved = orderRepository.save(order);

        return new OrderResponse(saved.getId(), saved.getTotal());
    }

    /**
     * Process payment for the given order and payment type.
     *
     * @param type
     * @param request
     * @return
     */
    public PaymentResponse processPayment(PaymentType type, PaymentRequest request) {

        PaymentOption processor = paymentOptionFactory.getPaymentType(type);

        return processor.processPayment(request);
    }

}
