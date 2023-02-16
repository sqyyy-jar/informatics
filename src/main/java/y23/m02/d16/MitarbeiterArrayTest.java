package y23.m02.d16;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Page("16.02.2023")
// Erstellt eine neue Klasse
public class MitarbeiterArrayTest {
    // Deklariert ein neues Attribut vom Typ Mitarbeiter[] namens mitarbeiter
    private Mitarbeiter[] mitarbeiter;

    // Definiert einen neuen Konstruktor, welcher eine IOException werfen kann
    public MitarbeiterArrayTest() throws IOException {
        // Deklariert eine Variable vom Typ BufferedReader namens br und initialisiert diese mit einer neuen Instanz vom Typ
        // BufferedReader; der Konstruktor aufruf von BufferedReader erhält außerdem einen neuen InputStreamReader, welcher
        // System.in engegennimmt
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Gibt die Frage aus
        System.out.println("Wie viele Mitarbeiter sollen verwaltet werden?: ");

        // Liest eine Zeile von br ein und wandelt diese in einen int um
        int anzahl = Integer.parseInt(br.readLine());

        // Weist dem Attribut mitarbeiter ein neues Array mit der angegebenen Länge zu
        mitarbeiter = new Mitarbeiter[anzahl];

        // Führt code für jeden Mitarbeiter in dem Array durch eine for Schleife aus
        for (int i = 0; i < mitarbeiter.length; i++) {
            // Fragt nach Eingabe des Namens des Mitarbeiters
            System.out.println("Geben Sie den Namen des Mitarbeiters " + (i + 1) + ". ein: ");
            // Deklariert eine neue Variable mit dem Namen name vom Typ String und initialisiert diese, indem sie eine neue Zeile
            // von br einliest.
            String name = br.readLine();
            // Fragt nach Einhabe des Gehalts des Mitarbeiters
            System.out.println("Geben Sie das Gehalt des Mitarbeiters " + (i + 1) + ". ein: ");
            // Deklariert eine neue Variable mit dem Namen gehalt vom Typ double und initialisert diese, indem sie eine neue Zeile
            // von br einliest und diese in einen double umwandelt
            double gehalt = Double.parseDouble(br.readLine());
            // Setzt den Mitarbeiter am Index i in dem Array des Attributs mitarbeiter zu einer neuen Instanz vom Typ Mitarbeiter,
            // welcher die Variablen name und gehalt im Konstruktor engegennimmt
            mitarbeiter[i] = new Mitarbeiter(name, gehalt);
        }

        // Ruft die Methode ausgabe auf
        ausgabe();
    }

    @Entrypoint
    // Definiert eine neue main-Methode, die eine IOException werfen kann
    public static void main(String[] args) throws IOException {
        // Gibt das erste Argument aus
        System.out.println(args[0]);

        // Instanziiert ein neues Objekt vom Typ MitarbeiterArrayTest
        new MitarbeiterArrayTest();
    }

    // Definiert eine neue Methode namens ausgabe
    public void ausgabe() {
        // Gibt eine leere Zeile aus
        System.out.println();
        // Gibt den Text aus
        System.out.println("############################");
        int sum = 0;
        // Ruft für jeden Mitarbeiter im Array in dem Attribut mitarbeiter die ausgeben Methode auf
        for (int i = 0; i < mitarbeiter.length; i++) {
            // Summiert die Gehälter der Mitarbeiter
            sum += mitarbeiter[i].getGehalt();
            mitarbeiter[i].ausgeben();
        }
        // Gibt das Durchschnittsgehalt der Mitarbeiter aus
        System.out.println("Durchschnittliches Gehalt: " + (sum / (double) mitarbeiter.length));
        // Gibt den Text aus
        System.out.println("############################");
    }
}
