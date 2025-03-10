package com.grepp.oop.d_inheriteance.c_before;

public class Run {

    public static void main(String[] args) {
        Desktop desktop = new Desktop(
            "삼성",
            "갤럭시북",
            2000000,
            "intel",
            true
        );

        SmartPhone smartphone = new SmartPhone(
            "사과",
            "아이폰",
            1300000,
            "긱벤치",
            "SKT"
        );

        Tv tv = new Tv(
            "삼성",
            "삼텐바이",
            1000000,
            52
        );

        desktop.on();
        smartphone.on();
        tv.on();
    }

}
