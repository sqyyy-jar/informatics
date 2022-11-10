package informatik.y22.m11.d10;

import informatik.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.35 - Wochentag Rechner")
public class A4_35 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tag   : ");
        int t = scanner.nextInt();
        System.out.print("Monat : ");
        int m = scanner.nextInt();
        System.out.print("Jahr  : ");
        int j = scanner.nextInt();
        if (m <= 2) {
            m += 10;
            j--;
        } else {
            m -= 2;
        }
        int c = j / 100;
        int y = j % 100;
        int h = (((26 * m - 2) / 10) + t + y + y / 4 + c / 4 - 2 * c) % 7;
        if (h < 0) {
            h += 7;
        }
        System.out.printf("Der %d.%d.%d ist ein %s.\n", t, m, j, switch (h) {
            case 0 -> "Sonntag";
            case 1 -> "Montag";
            case 2 -> "Dienstag";
            case 3 -> "Mittwoch";
            case 4 -> "Donnerstag";
            case 5 -> "Freitag";
            case 6 -> "Samstag";
            default -> "???";
        });
    }
}
