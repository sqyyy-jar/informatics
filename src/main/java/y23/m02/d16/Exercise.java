package y23.m02.d16;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.stream.IntStream;

@Page("16.02.2023/2")
public class Exercise {
    @Entrypoint
    public static void main() {
        // erstellt ein integer-array, welches mit den Werten 1-20 initialisiert wird
        int[] array = IntStream.rangeClosed(1, 20).toArray();
        // alternativ:
        // int[] array = new int[20];
        // for (int i = 0; i < array.length; i++) {
        //     array[i] = i + 1;
        // }

        // 1.
        // geht mit einer foreach-Schleife über alle Elemente des Arrays und gibt diese aus
        for (int i : array) {
            System.out.println(i);
        }
        // geht von dem Index des letzten Elements (length - 1) bis zum Index des ersten Elements (0)
        for (int i = array.length - 1; i >= 0; i--) {
            // gibt das Element mit dem Index i des Arrays aus
            System.out.println(array[i]);
        }

        // 2.
        // benutzt eine direkte Initialisierung, um ein Array zu erstellen
        int[] temperatures = {12, 14, 9, 12, 15, 16, 15, 12, 11, 8, 13, 13, 15, 12};
        // deklariert zwei neue Variablen mit jeweils dem Wert des ersten Elements im temperatures-Array
        // der erste Wert wird genutzt, da er im Array vorkommt
        int max = temperatures[0];
        int min = temperatures[0];
        // deklariert eine neue Variable und initialisiert diese mit dem Wert 0
        int sum = 0;
        // geht durch alle Temperaturen
        for (int temperature : temperatures) {
            // setzt die maximale Temperatur auf den Wert von `temperature`, wenn dieser größer als der aktuelle Wert von
            // `max` ist
            if (temperature > max) {
                max = temperature;
            }
            // setzt die minimale Temperatur auf den Wert von `temperature`, wenn dieser kleiner als der aktuelle Wert von
            // `min` ist
            if (temperature < min) {
                min = temperature;
            }
            // addiert `temperature` zu `sum` um alle Temperaturen zu summieren
            sum += temperature;
        }
        // gibt die maximale Temperatur aus
        System.out.println("Max: " + max);
        // gibt die minimale Temperatur aus
        System.out.println("Min: " + min);
        // gibt die Durchschnittstemperatur aus
        System.out.println("Avarage: " + ((double) sum / temperatures.length));

        // 3.
        // erstellt ein neues 2-dimensionales 10x10 array
        int[][] matrix = new int[10][10];
        // geht durch alle Werte des Arrays und setzt die Werte auf `x · y`
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                matrix[y - 1][x - 1] = x * y;
                // gibt die aktuelle Zelle aus
                System.out.printf("%4d", matrix[y - 1][x - 1]);
            }
            // gibt eine neue Zeile aus
            System.out.println();
        }
    }
}
