package y24.m03.d14;

import java.util.Arrays;

public class MiddleQuicksort {
    public static void quickSort(int[] array, int low, int high) {
        if (high - low < 1) {
            return;
        }
        int partitionIndex = partition(array, low, high);
        quickSort(array, low, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivotIndex = (low + high) / 2;
        int pivot = array[pivotIndex];
        int left = low;
        int right = high;
        while (left < right) {
            if (array[left] > pivot) {
                if (array[right] > pivot) {
                    right--;
                    continue;
                }
                if (right == pivotIndex) {
                    pivotIndex = left;
                }
                swap(array, left, right);
                right--;
            } else {
                left++;
            }
        }
        int element = array[left];
        if (pivotIndex > left) {
            if (element > pivot) {
                swap(array, pivotIndex, pivotIndex = left);
            } else {
                swap(array, pivotIndex, pivotIndex = left + 1);
            }
        } else if (pivotIndex < left) {
            if (element < pivot) {
                swap(array, pivotIndex, pivotIndex = left);
            } else {
                swap(array, pivotIndex, pivotIndex = left - 1);
            }
        }
        return pivotIndex;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void assertSorted(int[] array) {
        if (!isSorted(array)) {
            throw new AssertionError(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        {
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            quickSort(array, 0, 9);
            assertSorted(array);
        }
        {
            int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            quickSort(array, 0, 9);
            assertSorted(array);
        }
        {
            int[] array = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
            quickSort(array, 0, 9);
            assertSorted(array);
        }
        {
            int[] array = {3, 3, 2, 1, 4, 1, 2, 4, 5, 5};
            quickSort(array, 0, 9);
            assertSorted(array);
        }
    }
}