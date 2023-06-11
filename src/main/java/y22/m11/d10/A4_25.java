package y22.m11.d10;

import java.util.Scanner;

public class A4_25 {
    public static void run() {
        System.out.print("Anzahl der Zeilen: ");
        int lines = new Scanner(System.in).nextInt();
        for (int i = 1; i <= lines; i++) {
            System.out.println("*".repeat(i));
        }
    }
}
