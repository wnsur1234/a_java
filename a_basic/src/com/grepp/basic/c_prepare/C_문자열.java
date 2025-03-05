package com.grepp.basic.c_prepare;

public class C_문자열 {

    // NOTE CC01 String
    // 참조형 타입 : primitive type 을 제외한 모든 타입
    // new 연산자 : heap 영역에 데이터를 저장할 공간을 할당 받고, 주소를 변수에 연결해주는 연산자
    // 타입 변수명 = new 생성자 호출
    public static void main(String[] args) {
        String hello = new String("hello world");
        String hi = new String("hello world");

        System.out.println(System.identityHashCode(hello));
        System.out.println(System.identityHashCode(hi));
        System.out.println(hello == hi);

        // 모든 참조형 변수는 등위비교를 할 때, equals() 메서드로 비교해야 한다.
        System.out.println(hello.equals(hi));
        System.out.println("=== literal 초기화 ===");

        String a = "hello world";
        String b = "hello world";
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        //System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
