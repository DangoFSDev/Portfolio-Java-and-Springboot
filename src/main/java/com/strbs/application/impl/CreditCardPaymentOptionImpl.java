package com.strbs.application.impl;

import com.strbs.application.PaymentOptions;
import org.springframework.stereotype.Component;

import static com.strbs.common.constants.PaymentOptionsConstants.CREDIT_CARD;

@Component
public class CreditCardPaymentOptionImpl implements PaymentOptions {

    @Override
    public String getType() {

        return CREDIT_CARD;
    }

}
