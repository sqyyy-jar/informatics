package y22.m11.d10;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Scanner;

@Page(value = "A4.35", description = "Wochentag Rechner")
public class A4_35 {
    @Entrypoint
    public static void main() {
        // erstellt einen scanner
        Scanner scanner = new Scanner(System.in);
        // fragt den Tag ab
        System.out.print("Tag   : ");
        int t = scanner.nextInt();
        // fragt den Monat ab
        System.out.print("Monat : ");
        int m = scanner.nextInt();
        // speichert den Monat in einer anderen Variable, weil m verändert werden könnte
        int oldM = m;
        // fragt das Jahr ab
        System.out.print("Jahr  : ");
        int j = scanner.nextInt();
        // speichert das Jahr in einer anderen Variable, weil j verändert werden könnte
        int oldJ = j;
        // falls m <=2 ist, erhöhe m um 10 und erniedrige j um 1, andernfalls erniedrige m um 2
        if (m <= 2) {
            m += 10;
            j--;
        } else {
            m -= 2;
        }
        // berechnet die ganzzahligen Werte c = j / 100 und y = j % 100
        int c = j / 100;
        int y = j % 100;
        // berechnet den ganzzahligen Wert h
        int h = (((26 * m - 2) / 10) + t + y + y / 4 + c / 4 - 2 * c) % 7;
        // falls h < 0 sein sollte, erhöhe h um 7
        if (h < 0) {
            h += 7;
        }
        // gibt das Ergebnis in der folgenden Form aus: Der 24.12.2001 ist ein Montag.
        System.out.printf("Der %d.%d.%d ist ein %s.\n", t, oldM, oldJ, switch (h) {
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
