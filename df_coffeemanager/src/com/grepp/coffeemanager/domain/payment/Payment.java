package com.grepp.coffeemanager.domain.payment;

import com.grepp.coffeemanager.domain.account.Account;
import com.grepp.coffeemanager.domain.discount.DiscountPolicy;
import com.grepp.coffeemanager.domain.discount.PercentDiscountPolicy;
import com.grepp.coffeemanager.domain.order.Order;

public class Payment {

    private Order order;
    private int paymentPrice;
    private static final DiscountPolicy[] polies = {
        new PercentDiscountPolicy()
    };

    public Payment(Order order) {
        this.order = order;
        this.paymentPrice = calcPaymentPrice();
    }

    public int getPaymentPrice() {
        return calcPaymentPrice();
    }
    
    private int calcPaymentPrice() {
        int discountAmount = 0;
        for(DiscountPolicy policy : polies) {
            discountAmount += policy.getDiscountAmount(order);
        }
        
        paymentPrice = order.getOrderPrice() - discountAmount;
        return paymentPrice;
    }
    
    public void proceed() {
        Account account = Account.getInstance();
        account.registSales(paymentPrice);
    }
}
