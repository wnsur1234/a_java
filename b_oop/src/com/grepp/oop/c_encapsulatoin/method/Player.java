package com.grepp.oop.c_encapsulatoin.method;

// 연주자
// 연주를 하는 역할을 가지고 있는 객체
// 객체의 자율성 : 객체가 맡은 일은 객체가 알아서 수행하도록 코드를 작성
public class Player {

    private String instrument;

    public Player(String instrument) {
        this.instrument = instrument;
    }

    public void play(){
        prepare();
        readNote();
        playing();
        curtainCall();
        end();
    }

    private void prepare(){
        System.out.println( instrument + " 연주 준비합니다.");
    }

    private void readNote(){
        System.out.println( instrument + " 악보를 봅니다.");
    }

    private void playing(){
        System.out.println(instrument + " 연주를 합니다.");
    }

    private void curtainCall() {
        System.out.println("커튼콜을 진행합니다.");
    }

    private void end(){
        System.out.println("연주를 마칩니다.");
    }

}
