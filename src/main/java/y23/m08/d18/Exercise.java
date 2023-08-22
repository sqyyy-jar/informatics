package y23.m08.d18;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Random;
import java.util.stream.IntStream;

@Page("23/08/18")
public class Exercise {
    public void insertionSort(int[] array) {
        int reads = 0;
        int writes = 0;
        int outerIters = 0;
        int innerIters = 0;
        int comps = 0;
        for (int i = 1; i < array.length; i++) {
            outerIters++;
            int element = array[i]; reads++; // Einzusortierendes Element
            int j = i - 1;
            int moves = 0; // Anzahl an Verschiebungen
            // Verschiebe sortierte Elemente nach rechts, bis element einsortiert werden kann
            while (j >= 0 && element < array[j]) { innerIters++; reads++; comps++;
                array[j + 1] = array[j]; reads++; writes++;
                moves++;
                j--;
            } reads++; comps++;
            // Einsortierung des Elements
            if (moves > 0) {
                array[j + 1] = element; writes++;
            }
        }
        System.out.println("reads: " + reads);
        System.out.println("writes: " + writes);
        System.out.println("outerIters: " + outerIters);
        System.out.println("innerIters: " + innerIters);
        System.out.println("comps: " + comps);
        System.out.println("-----");
    }

    @Entrypoint
    public static void main(String[] args) {
        int[] a = IntStream.rangeClosed(1, 10).toArray();
        int[] b = IntStream.rangeClosed(1, 100).toArray();
        int[] c = new int[100];
        for (int i = 0; i < c.length; i++) {
            c[i] = 100 - i;
        }
        Random rand = new Random();
        int[] d = new int[100];
        for (int i = 0; i < d.length; i++) {
            d[i] = 1 + rand.nextInt(10);
        }
        Exercise exc = new Exercise();
        exc.insertionSort(a);
        exc.insertionSort(b);
        exc.insertionSort(c);
        exc.insertionSort(d);
    }
}
