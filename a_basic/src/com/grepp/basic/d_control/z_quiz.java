package com.grepp.basic.d_control;

import java.util.Scanner;

public class z_quiz {

    public static void main(String[] args) {
        game();
    }

    // q.
    // 1P 유저로부터 가위/바위/보 중 하나를 입력받으세요
    // 2P 유저로부터 가위/바위/보 중 하나를 입력받으세요.
    // 1P 유저기준에서 승/패/비김 여부를 출력해주세요.
    public static void quiz() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1P :" );
        String p1 = sc.next();
        System.out.print("2P : ");
        String p2 = sc.next();
    }






    private static void game() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1P :" );
        String p1 = sc.next();
        System.out.print("2P : ");
        String p2 = sc.next();

        if(p1.equals(p2)) {
            System.out.println("비겼습니다.");
            return;
        }

        if(p1.equals("가위") && p2.equals("보")) {
            System.out.println("이겼습니다.");
        }else if (p1.equals("바위") && p2.equals("가위")) {
            System.out.println("이겼습니다.");
        }else if(p1.equals("보") && p2.equals("바위")) {
            System.out.println("이겼습니다.");
        }else {
            System.out.println("졌습니다.");
        }
    }
}
