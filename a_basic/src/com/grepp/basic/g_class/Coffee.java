package com.grepp.basic.g_class;

// NOTE G01 class
// class를 만든다는 것은 새로운 타입을 만든 다는 것.
// class 이름 == type 이름
// 객체 생성 이후 인스턴스변수를 초기화 하지 않으면 JVM의 기본값으로 초기화
// 숫자 타입 : 0
// 참조형 타입 : null
// 문자 타입 : 유니코드 0번
// 논리 타입 : false
public class Coffee {
    String name;
    double price;
    int cost;
    int stock;
    int safetyStock;
    int salesCnt;
    char type;
    boolean soldOut;
    
    // NOTE G02 생성자
    // 생성자 : 사용자정의타입을 heap 영역의 메모리에 올릴 때, 인스턴스변수를 초기화 하기 위해 사용하는 메서드
    // 생성자를 하나도 작성하지 않으면, 자바의 컴파일러가 기본생성자(매개변수가 0개) 를 자동으로 생성
    public Coffee(){
        System.out.println("생성자 호출");
        int unicode = type;
        System.out.println("char 타입의 기본 값 : " + unicode);
    }
}
