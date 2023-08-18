package y23.m08.d18;

import java.util.Random;
import java.util.stream.IntStream;

public class Exercise {
    public int insertionSort(int[] array) {
        var memAccs = 0;
        for (var i = 1; i < array.length; i++) {
            var element = array[i];
            memAccs++;
            var j = i - 1;
            for (; j >= 0 && element < array[j]; j--) {
                memAccs++;
                array[j + 1] = array[j];
                memAccs += 2;
            }
            array[j + 1] = element;
            memAccs++;
        }
        return memAccs;
    }

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
        System.out.println(exc.insertionSort(a));
        System.out.println(exc.insertionSort(b));
        System.out.println(exc.insertionSort(c));
        System.out.println(exc.insertionSort(d));
    }
}
