package informatik.y22.m11.d10;

import informatik.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.26")
public class A4_26 {
    public static void run() {
        System.out.print("Positive Ganzzahl eingeben: ");
        int value = new Scanner(System.in).nextInt();
        if (value > 10000 || value < 0) {
            System.out.println("Inkorrekte Eingabe. Erwartet: 0 <= n <= 10000");
            return;
        }
        char[] digits = String.valueOf(value).toCharArray();
        int crossSum = 0;
        for (char digit : digits) {
            crossSum += digit - '0';
        }
        System.out.println("Die Quersumme ergibt sich zu: " + crossSum);
    }
}
