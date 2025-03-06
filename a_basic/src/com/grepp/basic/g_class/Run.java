package com.grepp.basic.g_class;

public class Run {

    public static void main(String[] args) {
        Coffee coffee = new Coffee(
            "americano",
            1000,
            500,
            10,
            3,
            0,
            'T',
            false
        );

        System.out.println(coffee.name);
        System.out.println(coffee.price);
        System.out.println(coffee.type);

        coffee.type = 'Q';
        System.out.println(coffee.type);
    }

}
