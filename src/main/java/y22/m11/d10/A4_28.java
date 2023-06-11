package y22.m11.d10;

import java.util.*;

public class A4_28 {
    public static void run() {
        System.out.print("Positive ganze Zahl: ");
        int value = new Scanner(System.in).nextInt();
        if (value < 0) {
            System.out.println("Inkorrekte Eingabe. Erwartet: 0 <= n");
            return;
        }
        char[] chars = String.valueOf(value).toCharArray();
        int i = chars.length;
        System.out.print("Zerlegt rückwärts:");
        while (i > 0) {
            i--;
            System.out.print(" " + switch (chars[i]) {
                case '0' -> "null";
                case '1' -> "eins";
                case '2' -> "zwei";
                case '3' -> "drei";
                case '4' -> "vier";
                case '5' -> "fünf";
                case '6' -> "sechs";
                case '7' -> "sieben";
                case '8' -> "acht";
                case '9' -> "neun";
                default -> "?";
            });
        }
        System.out.println();
    }
}
