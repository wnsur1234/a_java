package com.grepp.oop.d_inheriteance.c_before;

public class Tv {

    private String brand;
    private String name;
    private int price;
    private int size;

    public Tv(String brand, String name, int price, int size) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public void on(){
        System.out.println(name + " 켰습니다.");
    }

    @Override
    public String toString() {
        return "Tv{" +
            "brand='" + brand + '\'' +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", size=" + size +
            '}';
    }
}
