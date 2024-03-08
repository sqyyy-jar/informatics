package y24.m02.d09;

import java.util.Arrays;

public class Tests {
    private final static int[][] arrays = new int[][]{
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        {1, 2, 2, 2},
        {1, 1, 1, 2},
    };

    private static void assertSorted(ArrayStats stats, String message) {
        var array = stats.unwrap();
        if (array.length == 0) {
            return;
        }
        var last = array[0];
        for (var x : array) {
            if (x < last) {
                throw new RuntimeException(message);
            }
        }
    }

    public static void testLeft() {
        for (var array : arrays) {
            var bs = new BogoQuicksort(BogoQuicksort.Pivot.LEFT);
            var stats = new ArrayStats(array.clone());
            bs.quickSort(stats, 0, array.length - 1);
            assertSorted(stats, Arrays.toString(array));
        }
    }

    public static void testMiddle() {
        for (var array : arrays) {
            var bs = new BogoQuicksort(BogoQuicksort.Pivot.MIDDLE);
            var stats = new ArrayStats(array.clone());
            bs.quickSort(stats, 0, array.length - 1);
            assertSorted(stats, Arrays.toString(array));
        }
    }

    public static void testRight() {
        for (var array : arrays) {
            var bs = new BogoQuicksort(BogoQuicksort.Pivot.RIGHT);
            var stats = new ArrayStats(array.clone());
            bs.quickSort(stats, 0, array.length - 1);
            assertSorted(stats, Arrays.toString(array));
        }
    }

    public static void testRandom() {
        for (var array : arrays) {
            var bs = new BogoQuicksort(BogoQuicksort.Pivot.RANDOM);
            var stats = new ArrayStats(array.clone());
            bs.quickSort(stats, 0, array.length - 1);
            assertSorted(stats, Arrays.toString(array));
        }
    }

    public static void testAll() {
        testLeft();
        testMiddle();
        testRight();
        testRandom();
    }
}
