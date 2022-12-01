package y22.m11.d10;

import informatics.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.36 - Ostersonntag berechnen")
public class A4_36 {
    public static void run() {
        System.out.print("Jahr: ");
        int j = new Scanner(System.in).nextInt();
        if (j < 1 || j > 8202) {
            System.out.println("Nur die Jahre von 1 bis 8202 sind gültig.");
            return;
        }
        int a = j % 19;
        int b = j % 4;
        int c = j % 7;
        int m = (8 * (j / 100) + 13) / 25 - 2;
        int s = j / 100 - j / 400 - 2;
        m = (15 + s - m) % 30;
        int n = (6 + s) % 7;
        int d = (m + 19 * a) % 30;
        if (d == 29) {
            d = 28;
        } else if (d == 28 && a >= 11) {
            d = 27;
        }
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int day = 21 + d + e + 1;
        int month;
        if (day > 31) {
            day = day % 31;
            month = 4;
        } else {
            month = 3;
        }
        System.out.printf("Der Ostersonntag ist im Jahr %d am %d. %s.\n", j, day, switch (month) {
            case 3 -> "März";
            case 4 -> "April";
            default -> "???";
        });
    }
}
