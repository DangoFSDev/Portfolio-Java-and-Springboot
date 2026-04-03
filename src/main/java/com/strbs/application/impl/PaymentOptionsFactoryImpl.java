package com.strbs.application.impl;

import javax.inject.Inject;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;

import com.strbs.application.PaymentOptions;
import com.strbs.application.PaymentOptionsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentOptionsFactoryImpl implements PaymentOptionsFactory {

    private final Map<String, PaymentOptions> paymentOptionsMap = new HashMap<>();

    @Inject
    public PaymentOptionsFactoryImpl(CreditCardPaymentOptionImpl creditCardPaymentOption,
            GCashPaymentOptionImpl gCashPaymentOption) {

        paymentOptionsMap.put(creditCardPaymentOption.getType(), creditCardPaymentOption);
        paymentOptionsMap.put(gCashPaymentOption.getType(), gCashPaymentOption);
    }

    @Override
    public PaymentOptions getPaymentOption(String type) {

        return paymentOptionsMap.get(type);
    }
}
