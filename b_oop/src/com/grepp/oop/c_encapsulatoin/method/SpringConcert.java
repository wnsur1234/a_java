package com.grepp.oop.c_encapsulatoin.method;

public class SpringConcert {

    public void startConcert(){
        System.out.println("봄 콘서트를 시작합니다!");
        Player player = new Player("바이올린");
        player.play();
        System.out.println("봄 콘서트 마칩니다.");
    }

}
