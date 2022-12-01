package y22.m11.d10;

import informatics.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.32 - short2long Basis Rechner")
public class A4_32 {
    public static void run() {
        System.out.print("   Dezimalzahl: ");
        final long BASE = 2;
        short d = new Scanner(System.in).nextShort();
        long m = 1;
        long b = 0;
        while (d > 0) {
            b += (d % BASE) * m;
            d /= BASE;
            m *= 10;
        }
        System.out.println("als Binärzahl: " + b);
    }
}
