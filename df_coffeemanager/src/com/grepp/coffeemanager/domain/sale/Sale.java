package com.grepp.coffeemanager.domain.sale;

import com.grepp.coffeemanager.domain.multilingual.payment.ChinaPaymentTranslator;
import com.grepp.coffeemanager.domain.multilingual.payment.PaymentTranslator;
import com.grepp.coffeemanager.domain.multilingual.payment.SpainPaymentTranslator;
import com.grepp.coffeemanager.domain.multilingual.payment.UsaPaymentTranslator;
import com.grepp.coffeemanager.domain.order.Order;
import com.grepp.coffeemanager.domain.payment.Payment;

public class Sale {

    public PaymentTranslator takeOrder(Order order) {
        order.proceed();
        Payment payment = new Payment(order);
        payment.proceed();
        return new SpainPaymentTranslator(new ChinaPaymentTranslator(payment));
    }
}
