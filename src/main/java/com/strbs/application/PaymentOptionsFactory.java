package com.strbs.application;

public interface PaymentOptionsFactory {
    public PaymentOptions getPaymentOption(String type);
}
