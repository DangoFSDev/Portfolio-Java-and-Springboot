package com.ecos.domain.payment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ecos.common.enums.PaymentType;

import org.springframework.stereotype.Component;

@Component
public class PaymentOptionFactory {

    private final Map<PaymentType, PaymentOption> processors;

    public PaymentOptionFactory(List<PaymentOption> processorList) {

        this.processors = processorList.stream()
                                       .collect(Collectors.toMap(
                                               PaymentOption::getPaymentType,
                                               p -> p
                                       ));
    }

    public static PaymentOption getPaymentType(PaymentType type) {

        return processors.get(type);
    }

}
