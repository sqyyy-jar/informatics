package y22.m11.d10;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Scanner;

@Page(value = "A4.36", description = "Ostersonntag berechnen")
public class A4_36 {
    @Entrypoint
    public static void main() {
        // liest das Jahr ein
        System.out.print("Jahr: ");
        int j = new Scanner(System.in).nextInt();
        if (j < 1 || j > 8202) {
            System.out.println("Nur die Jahre von 1 bis 8202 sind gültig.");
            return;
        }
        // berechnet a = j % 19
        int a = j % 19;
        // berechnet b = j % 4
        int b = j % 4;
        // berechnet c = j % 7
        int c = j % 7;
        // bestimmt m
        int m = (8 * (j / 100) + 13) / 25 - 2;
        // bestimmt s
        int s = j / 100 - j / 400 - 2;
        // verändert m
        m = (15 + s - m) % 30;
        // bestimmt n
        int n = (6 + s) % 7;
        // bestimmt d
        int d = (m + 19 * a) % 30;
        // falls d = 29 ist, setze d = 28
        // andernfalls: falls d = 28 und a >= 11 ist, setze d = 27
        if (d == 29) {
            d = 28;
        } else if (d == 28 && a >= 11) {
            d = 27;
        }
        // setze e
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        // bestimme tag und monat
        int day = 21 + d + e + 1;
        int month;
        if (day > 31) {
            day = day % 31;
            month = 4;
        } else {
            month = 3;
        }
        // gibt das Datum des Ostersonntags für das eingelesenes Jahr aus
        System.out.printf("Der Ostersonntag ist im Jahr %d am %d. %s.\n", j, day, switch (month) {
            case 3 -> "März";
            case 4 -> "April";
            default -> "???";
        });
    }
}
