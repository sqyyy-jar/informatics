package y24.m02.d09;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BogoQuicksort {
    private final Random random;

    public BogoQuicksort() {
        this.random = new Random();
    }

    public int partition(ObservedArray array, int left, int right) {
        int pivotIndex = random.nextInt(left, right + 1);
        swap(array, pivotIndex, right);
        int pivot = array.get(right);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array.get(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public int partitionLeft(ObservedArray array, int left, int right) {
        swap(array, left, right);
        int pivot = array.get(right);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array.get(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public int partitionMid(ObservedArray array, int left, int right) {
        swap(array, left + (right - left) / 2, right);
        int pivot = array.get(right);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array.get(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public int partitionRight(ObservedArray array, int left, int right) {
        int pivot = array.get(right);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array.get(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public void quickSort(ObservedArray array, int left, int right) {
        if (right <= left) {
            return;
        }
        int partitionIndex = partitionMid(array, left, right);
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
    }

    public void swap(ObservedArray array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    public static ObservedArray newSorted(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = 10 - i;
        }
        return new ObservedArray(array);
    }

    public static void main(String[] args) {
        BogoQuicksort bogoQs = new BogoQuicksort();
        var array = newSorted(10);
        System.out.println(array);
        bogoQs.quickSort(array, 0, array.len() - 1);
        System.out.println(array);
        System.out.println(array.getReads() + "/" + array.getWrites());
    }
}
