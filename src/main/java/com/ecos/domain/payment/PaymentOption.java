package com.ecos.domain.payment;

import com.ecos.application.dto.request.PaymentRequest;
import com.ecos.application.dto.response.PaymentResponse;
import com.ecos.common.enums.PaymentType;

public interface PaymentOption {

    PaymentType getPaymentType();

    PaymentResponse processPayment(PaymentRequest paymentRequest);

}
