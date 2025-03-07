package com.grepp.oop.c_encapsulatoin;

public class Run {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.setName("아메리카노");
        System.out.println(coffee.getName());

        coffee.setCost(-1000);
        System.out.println(coffee.getCost());
    }

}
