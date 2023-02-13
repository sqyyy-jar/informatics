package y23.m02.d13;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

@Page("13.02.2023")
public class ArrayUebung {
    // Deklarieren Sie hier einen neuen Array a des Typs int mit der Laenge 6 (keine Listeninitialisierung)

    int[] a = new int[6];

    // Deklarieren Sie hier einen neuen Array b des Typs double mit der Laenge 4 (Listeninitialisierung mit 0.4, 0.32, 0.45, 0.25)

    double[] b = {.4, .32, .45, .25};

    public ArrayUebung() {

        // Geben Sie von a und b das Element mit Index 0 ueber die Systemausgabe aus!

        System.out.println(a[0]);
        System.out.println(b[0]);

        // Weisen Sie dem Element mit Index 0 des Arrays a den Wert 199 zu

        a[0] = 199;

        // Weisen Sie dem Element mit Index 1 des Arrays a den Wert 46 zu

        a[1] = 46;

        // Weisen Sie dem Element mit Index 2 des Arrays a den Wert 199 zu

        a[2] = 199;

        // Prüfen Sie mittels if Bedingung, ob das Element mit Index 3 des Arrays a gleich 0 ist.
        // Ist dies der Fall so soll ausgegeben werden: "Der Wert des Element mit Index 3 ist nicht initialisiert worden
        // Ansonsten soll der Wert ausgegeben werden.
        // Überprüfen Sie ob Ihre Bedingung funktioniert, indem Sie vorher dem Element mit Index 3 des Arrays a einen anderen Wert als 0 zuweisen

        a[3] = 5;

        if (a[3] == 0) {
            System.out.println("Der Wert des Element mit Index 3 ist nicht initialisiert worden");
        } else {
            System.out.println(a[3]);
        }

        // Programmieren Sie mittels einer for-Schleife eine Ausgabe aller Elemente der Arrays a

        for (int i : a) {
            System.out.println(i);
        }

        // Programmieren Sie mittels einer for-Schleife eine Ausgabe aller Elemente der Arrays b

        for (double v : b) {
            System.out.println(v);
        }

    }

    @Entrypoint
    public static void main(String[] args) {
        new ArrayUebung();
    }
}
