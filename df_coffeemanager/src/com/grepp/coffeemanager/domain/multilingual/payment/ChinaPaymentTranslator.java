package com.grepp.coffeemanager.domain.multilingual.payment;

import com.grepp.coffeemanager.domain.payment.Payment;

public class ChinaPaymentTranslator extends PaymentDecorator{
    
    public ChinaPaymentTranslator(PaymentTranslator target) {
        super(target);
    }
    
    @Override
    public String translateOrderName() {
        String orderName = target.translateOrderName();
        Payment payment = origin();
        
        String coffee = payment.getOrder().getCoffee().getName();
        int orderCnt = payment.getOrder().getOrderCnt();
        orderName += ", " + orderCnt + "杯 " + coffee;
        return orderName;
    }
    
    @Override
    public String translatePaymentPrice() {
        Payment payment = origin();
        double paymentPrice = payment.getPaymentPrice();
        double wian = paymentPrice / 200;
        return target.translatePaymentPrice() + ", " + String.format("%.2f wian", wian);
    }
    
    @Override
    public Payment origin() {
        return target.origin();
    }
}
