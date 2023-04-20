package y23.m03.d06;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Arrays;
import java.util.Objects;
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

    public static int[] filterDuplicates(int[] array) {
        long[] bitset = new long[(array.length & 63) == 0
            ? array.length >> 6
            : (array.length >> 6) + 1];
        int uniqueCount = 0;
        for (int i = 0; i < array.length; i++) {
            long bitPack = bitset[i >> 6];
            long bit = bitPack >> (i & 63) & 1;
            if (bit != 0) {
                continue;
            }
            uniqueCount++;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] != array[j]) {
                    continue;
                }
                bitset[j >> 6] |= 1L << (j & 63);
            }
        }
        int[] newArray = new int[uniqueCount];
        int index = 0;
        for (int i = 0; i < bitset.length; i++) {
            long bitPack = bitset[i];
            int bitPackLength = 64;
            if (i == bitset.length - 1) {
                bitPackLength = (array.length & 63) == 0
                    ? 64
                    : array.length & 63;
            }
            for (int bitIndex = 0; bitIndex < bitPackLength; bitIndex++) {
                long bit = bitPack >> bitIndex & 1;
                if (bit != 0) {
                    continue;
                }
                newArray[index++] = array[i * 64 + bitIndex];
            }
        }
        return newArray;
    }

    @Entrypoint
    public static void main() {
        var testArray = new int[128 * 4];
        var random = new Random();
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt(128);
        }
        System.out.println("Array duplicate filtering");
        testArray = filterDuplicates(testArray);
        var list = Arrays.stream(testArray)
            .boxed()
            .toList();
        for (int i = 0; i < 128; i++) {
            if (!list.contains(i)) {
                System.out.println("Not found: " + i);
            }
        }
        System.out.println("Length: " + list.size());
    }
}
