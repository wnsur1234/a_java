package com.grepp.coffeemanager.domain.payment;

import com.grepp.coffeemanager.domain.order.Order;

public class Payment {

    private Order order;
    private int paymentPrice;

    public int getPaymentPrice() {
        return paymentPrice;
    }
}
