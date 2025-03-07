package com.grepp.coffeemanager.domain.coffee;

public class Coffee {

    private String name;
    private int price;
    private int purchasePrice;
    private int stock;
    private int safetyStock;
    private int salesCnt;

    public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock) {
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.safetyStock = safetyStock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getStock() {
        return stock;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public int getSalesCnt() {
        return salesCnt;
    }
}
