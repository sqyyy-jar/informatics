package y23.m04.d27;

public class Main {
    public static void bubbleSort(int[] array) {
        int length = array.length;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                int a = array[i];
                int b = array[i + 1];
                if (a > b) {
                    array[i] = b;
                    array[i + 1] = a;
                }
            }
            length--;
        }
    }
}