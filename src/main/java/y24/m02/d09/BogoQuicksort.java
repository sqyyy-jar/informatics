package y24.m02.d09;

import java.util.Random;

public class BogoQuicksort {
    private final Pivot pivot;
    private final Random random;

    public BogoQuicksort(Pivot pivot) {
        this.pivot = pivot;
        this.random = new Random();
    }

    public int partition2(ArrayStats array, int left, int right) {
        switch (this.pivot) {
            case LEFT -> swap(array, left, right);
            case MIDDLE -> swap(array, left + (right - left) / 2, right);
            case RIGHT -> {}
            case RANDOM -> swap(array, random.nextInt(left, right + 1), right);
        }
        int pivot = array.get(right);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            array.incComps();
            if (array.get(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public int partition(ArrayStats array, int left, int right) {
        switch (this.pivot) {
            case LEFT -> swap(array, left, right);
            case MIDDLE -> swap(array, left + (right - left) / 2, right);
            case RIGHT -> {}
            case RANDOM -> swap(array, random.nextInt(left, right + 1), right);
        }
        int pivot = array.get(right);
        int i = left;
        for (int j = left; j <= right - 1; j++) {
            array.incComps();
            if (array.get(j) < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }

    public void quickSort(ArrayStats array, int left, int right) {
        if (right <= left) {
            return;
        }
        int partitionIndex = partition(array, left, right);
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
    }

    public void swap(ArrayStats array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    public static ArrayStats newSorted(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = 10 - i;
        }
        return new ArrayStats(array);
    }

    public static void main(String[] args) {
        Tests.testAll();
//        BogoQuicksort bogoQs = new BogoQuicksort(Pivot.MIDDLE);
////        var array = newSorted(10);
//        var array = new ArrayStats(9, 8, 7, 6, 5, 4, 3, 2, 1);
//        System.out.println(array);
//        bogoQs.quickSort(array, 0, array.len() - 1);
//        System.out.println(array);
//        System.out.println(array.getReads() + "/" + array.getWrites() + "/" + array.getComps());
    }

    public enum Pivot {
        LEFT, MIDDLE, RIGHT, RANDOM;
    }
}
