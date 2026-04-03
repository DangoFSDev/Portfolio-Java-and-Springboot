package com.strbs.application.impl;

import com.strbs.application.PaymentOptions;
import org.springframework.stereotype.Component;

import static com.strbs.common.constants.PaymentOptionsConstants.G_CASH;

@Component
public class GCashPaymentOptionImpl implements PaymentOptions {

    @Override
    public String getType() {

        return G_CASH;
    }

}
