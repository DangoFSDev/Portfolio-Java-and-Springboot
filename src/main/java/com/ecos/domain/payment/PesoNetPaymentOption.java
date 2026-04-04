package com.ecos.domain.payment;

import com.ecos.application.dto.request.PaymentRequest;
import com.ecos.application.dto.response.PaymentResponse;
import com.ecos.common.enums.PaymentType;

public class PesoNetPaymentOption implements PaymentOption {

    @Override
    public PaymentType getPaymentType() {

        return PaymentType.PESONET;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        return null;
    }

}
