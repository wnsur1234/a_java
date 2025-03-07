package com.grepp.basic.d_control;

import java.util.Scanner;

public class F_star {

    public static void main(String[] args) {
        //q1();
        q5();
    }

    private static void q5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 : ");
        int num = sc.nextInt();

        for (int x = 1; x <= num ; x++) {
            for (int i = 0; i < num - x; i++) {
                System.out.print(' ');
            }

            for (int i = 0; i < 2 * x - 1; i++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int y = 1; y < num; y++) {
            for (int i = 0; i < y; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < 2*(num-y)-1; i++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    private static void q1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("row: ");
        int row = sc.nextInt();

        System.out.print("col: ");
        int col = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }





    }

}
