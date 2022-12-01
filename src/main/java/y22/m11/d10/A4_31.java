package y22.m11.d10;

import informatics.Exercise;

import java.util.Scanner;

@Exercise("Aufgabe 4.31 - Zahlenraten Spiel")
public class A4_31 {
    public static void run() {
        System.out.println("""
                  === Zahlenraten-Spiel ===
            In diesem Spiel wird eine zufällige
            Zahl zwischen 1 und 100 generiert.
            Diese ist von dem Spieler zu erraten.
                  === Zahlenraten-Spiel ===
            """);
        int geheimZahl = (int) (99 * Math.random() + 1);
        int versuch = 1;
        Scanner stdin = new Scanner(System.in);
        while (true) {
            System.out.print(versuch + ". Versuch: ");
            int guess = stdin.nextInt();
            if (guess == geheimZahl) {
                System.out.println("Du hast die Zahl beim " + versuch + ". Versuch erraten!");
                break;
            } else if (geheimZahl > guess) {
                System.out.println("Die Zahl ist größer!");
            } else {
                System.out.println("Die Zahl ist kleiner!");
            }
            versuch++;
        }
    }
}
