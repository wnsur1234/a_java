package com.grepp.basic.c_prepare;

public class D_문자열결합 {

    public static void main(String[] args) {
        
        // NOTE CD01 문자열 결합
        String name = "하명도";
        String job = "강사";
        String lecture = name + ":" + job;

        System.out.println(lecture);

        // 문자열과 숫자를 결합할 때
        // 문자열결합연산자(+) 의 피연산자 중에서 하나라도 문자열이면 문자열 결합으로 수행
        System.out.println(10 + "호 기차");
        System.out.println(10 + 100 + "호 기차");
        System.out.println("이번 기차는 " + 10 + 100 + "호 기차");
        // "이번 기차는 10" + 100 => "이번 기차는 10100"
        System.out.println("이번 기차는 " + (10 + 100) + "호 기차");
    }
}
