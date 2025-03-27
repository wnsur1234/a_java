package com.grepp.thread.c_threadsafe;

public class Soi extends Thread{
    
    private Bottle bottle;
    
    public Soi(Bottle bottle) {
        this.bottle = bottle;
    }
    
    @Override
    public void run() {
        String name = getName();
        for (int i = 0; i < 10000; i++) {
            System.out.println(getName() + " : " + "간장 발견!");
            System.out.println(getName() + " : " + bottle.input(name, "간장") 
                                   + " 냉장고에 넣는다.");
        }
    }
}
