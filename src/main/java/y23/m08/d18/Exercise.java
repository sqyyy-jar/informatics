package y23.m08.d18;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.stream.IntStream;

@Page("23/08/18")
public class Exercise {
    public void insertionSort(int[] array) {
        // bc = 2n - 2
        // wc = n*n - 1
        int reads = 0;
        // bc = 0
        // wc = Σ[1...n - 1]
        int writes = 0;
        // bc = wc = n - 1
        int outerIters = 0;
        // bc = 0
        // wc = Σ[1...n - 1]
        int innerIters = 0;
        // bc = n - 1
        // wc = Σ[1...n - 1]
        int comps = 0;
        for (int i = 1; i < array.length; i++) {
            outerIters++;
            int element = array[i]; reads++; // Einzusortierendes Element
            int j = i - 1;
            int moves = 0; // Anzahl an Verschiebungen
            // Verschiebe sortierte Elemente nach rechts, bis element einsortiert werden kann
            while (j >= 0 && element < array[j + (reads++ * comps++ * 0)]) { innerIters++;
                array[j + 1] = array[j]; reads++; writes++;
                moves++;
                j--;
            }
            // Einsortierung des Elements
            if (moves > 0) {
                array[j + 1] = element; writes++;
            }
        }
        System.out.println("---");
        System.out.println("reads: " + reads);
        System.out.println("writes: " + writes);
        System.out.println("outerIters: " + outerIters);
        System.out.println("innerIters: " + innerIters);
        System.out.println("comps: " + comps);
    }

    public void optBubbleSort(int[] array) {
        for (int i = array.length; i > 1; i--) {
            int swaps = 0;
            for (int j = 1; j < i; j++) {
                int prev = array[j - 1];
                int curr = array[j];
                if (prev > curr) {
                    array[j - 1] = curr;
                    array[j] = prev;
                    swaps++;
                }
            }
            if (swaps == 0) {
                break;
            }
        }
    }

    @Entrypoint
    public static void main(String[] args) {
        int[] a = IntStream.rangeClosed(1, 10).toArray();
        int[] b = IntStream.rangeClosed(1, 20).toArray();
        int[] c = IntStream.rangeClosed(1, 50).toArray();
        int[] d = IntStream.rangeClosed(1, 100).toArray();
        int[] e = IntStream.rangeClosed(1, 500).toArray();
        Exercise exc = new Exercise();
        exc.run(a);
        exc.run(b);
        exc.run(c);
        exc.run(d);
        exc.run(e);
    }

    void run(int[] array) {
        System.out.println("# length = " + array.length);
        int[] bc = array.clone();
        int[] wc = rev(array.clone());
        insertionSort(bc);
        insertionSort(wc);
        System.out.println();
    }

    static int[] rev(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int element = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = element;
        }
        return array;
    }
}
