package com.grepp.coffeemanager.domain.multilingual.payment;

import com.grepp.coffeemanager.domain.payment.Payment;

public class UsaPaymentTranslator extends PaymentDecorator{
    
    public UsaPaymentTranslator(PaymentTranslator target) {
        super(target);
    }
    
    @Override
    public String translateOrderName() {
        String orderName = target.translateOrderName();
        Payment payment = origin();
        
        String coffeeCnt = payment.getOrder().getCoffee().getName();
        int orderCnt = payment.getOrder().getOrderCnt();
        orderName += ", " + orderCnt + "cup of " + coffeeCnt;
        return orderName;
    }
    
    @Override
    public String translatePaymentPrice() {
        Payment payment = origin();
        double paymentPrice = payment.getPaymentPrice();
        double dollar = paymentPrice / 1400;
        return target.translatePaymentPrice() + ", " + String.format("%.2f dollar", dollar);
    }
    
    @Override
    public Payment origin() {
        return target.origin();
    }

}
