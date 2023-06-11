package y22.m11.d10;

import java.util.Scanner;

public class A4_33 {
    public static void run() {
        System.out.print("Höhe des Baumes: ");
        int height = new Scanner(System.in).nextInt();
        if (height < 2) {
            System.out.println("Die Höhe des Baumes muss ungerade und größer als 1 sein.");
            return;
        }
        int initialMargin = height - 1;
        int margin = initialMargin;
        for (int i = 1; i < height * 2; i += 2) {
            System.out.print(" ".repeat(margin));
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(margin)); // optional
            System.out.println();
            margin--;
        }
        System.out.print(" ".repeat(initialMargin));
        System.out.print("I");
        System.out.print(" ".repeat(initialMargin));
        System.out.println();
    }
}
