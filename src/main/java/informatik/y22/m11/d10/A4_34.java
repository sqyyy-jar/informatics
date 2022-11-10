package informatik.y22.m11.d10;

import informatik.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.34 - Befreundete Zahlen Rechner")
public class A4_34 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Erste Zahl  : ");
        int a = scanner.nextInt();
        System.out.print("Zweite Zahl : ");
        int b = scanner.nextInt();
        if (a < 1 || b < 1) {
            System.out.println("Die beiden Zahlen dürfen nicht kleiner als 1 sein.");
            return;
        }
        int at = 0;
        int bt = 0;
        for (int i = 1; i < a / 2 + 1; i++) {
            if (a % i == 0) at += i;
        }
        for (int i = 1; i < b / 2 + 1; i++) {
            if (b % i == 0) bt += i;
        }
        if (at == b && bt == a) {
            System.out.println("Die beiden Zahlen sind miteinander befreundet!");
        } else {
            System.out.println("Die beiden Zahlen sind nicht miteinander befreundet!");
        }
    }
}
