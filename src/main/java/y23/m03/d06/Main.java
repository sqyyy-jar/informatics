package y23.m03.d06;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Arrays;
import java.util.Random;

@Page("06.03.2023")
public class Main {
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int length = array.length;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                T a = array[i];
                T b = array[i + 1];
                if (a.compareTo(b) > 0) {
                    array[i] = b;
                    array[i + 1] = a;
                }
            }
            length--;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int start = 0; start < array.length; start++) {
            int best = start;
            for (int i = start; i < array.length; i++) {
                if (array[i].compareTo(array[best]) < 0) {
                    best = i;
                }
            }
            T a = array[start];
            array[start] = array[best];
            array[best] = a;
        }
    }

    public static void selectionSort(int[] array) {
        for (int start = 0; start < array.length; start++) {
            int best = start;
            for (int i = start; i < array.length; i++) {
                if (array[i] < array[best]) {
                    best = i;
                }
            }
            int a = array[start];
            array[start] = array[best];
            array[best] = a;
        }
    }

    @Entrypoint
    public static void main() {
        var testArray = new int[100_000];
        var random = new Random();
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt(1, 50);
        }
        System.out.println("Array randomized");
        selectionSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
