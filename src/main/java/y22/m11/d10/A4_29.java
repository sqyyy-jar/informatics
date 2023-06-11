package y22.m11.d10;

import java.util.Scanner;

public class A4_29 {
    public static void run() {
        System.out.print("Geben sie eine Zahl ein: ");
        int value = new Scanner(System.in).nextInt();
        System.out.print("Die Vielfachen:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + value * i);
        }
        System.out.println();
    }
}
