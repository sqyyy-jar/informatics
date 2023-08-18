package y23.m08.d18;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Random;
import java.util.stream.IntStream;

@Page("23/08/18")
public class Exercise {
    public void insertionSort(int[] array) {
        var reads = 0;
        var writes = 0;
        var outerIters = 0;
        var innerIters = 0;
        for (var i = 1; i < array.length; i++) {
            outerIters++;
            var element = array[i];
            reads++;
            var j = i - 1;
            for (; j >= 0 && element < array[j]; j--) {
                innerIters++;
                reads++;
                array[j + 1] = array[j];
                reads++;
                writes++;
            }
            array[j + 1] = element;
            writes++;
        }
        System.out.println("reads: " + reads);
        System.out.println("writes: " + writes);
        System.out.println("outerIters: " + outerIters);
        System.out.println("innerIters: " + innerIters);
        System.out.println("-----");
    }

    @Entrypoint
    public static void main(String[] args) {
        var a = IntStream.rangeClosed(1, 10).toArray();
        var b = IntStream.rangeClosed(1, 100).toArray();
        var c = new int[100];
        for (int i = 0; i < c.length; i++) {
            c[i] = 100 - i;
        }
        var rand = new Random();
        var d = new int[100];
        for (int i = 0; i < d.length; i++) {
            d[i] = 1 + rand.nextInt(10);
        }
        var exc = new Exercise();
        exc.insertionSort(a);
        exc.insertionSort(b);
        exc.insertionSort(c);
        exc.insertionSort(d);
    }
}
