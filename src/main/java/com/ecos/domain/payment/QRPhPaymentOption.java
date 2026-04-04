package com.ecos.domain.payment;

import com.ecos.application.dto.request.PaymentRequest;
import com.ecos.application.dto.response.PaymentResponse;
import com.ecos.common.enums.PaymentType;

public class QRPhPaymentOption implements PaymentOption {

    @Override
    public PaymentType getPaymentType() {

        return PaymentType.QRPH;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        return null;
    }

}
