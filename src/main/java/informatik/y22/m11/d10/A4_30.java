package informatik.y22.m11.d10;

import informatik.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.30 - Zinseszins Rechner")
public class A4_30 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Anzulegender Geldbetrag in Euro: ");
        double anlage = scanner.nextDouble();
        System.out.print("Jahreszins (z.B. 0.1 für 10 Prozent): ");
        double jahreszins = scanner.nextDouble();
        System.out.print("Laufzeit (in Jahren): ");
        int laufzeit = scanner.nextInt();
        for (int i = 1; i <= laufzeit; i++) {
            anlage += anlage * jahreszins;
            System.out.println("Wert nach 1 Jahren: " + anlage + "€");
        }
    }
}
