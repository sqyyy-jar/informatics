import java.util.Arrays;

public class Sorter {
    public void bubbleSort(int[] array) {
        // Gehe über Abschnitte des Arrays, die immer kleiner werden (Array wird hinten
        // kleiner)
        for (int end = array.length; end > 1; end--) {
            for (int i = 0; i < end - 1; i++) {
                // Tausche den jetzigen Eintrag und den nächsten, wenn der jetzige größer ist
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    public void selectionSort(int[] array) {
        // Gehe über Abschnitte des Arrays, die immer kleiner werden (Array wird vorne
        // kleiner)
        for (int start = 0; start < array.length; start++) {
            // Finde die kleinste Zahl in dem Abschnitt
            int best = start;
            for (int i = start; i < array.length; i++) {
                if (array[i] < array[best]) {
                    best = i;
                }
            }
            // Tausche das erste Element des Abschnitts mit dem kleinsten Element des
            // Abschnitts
            int temp = array[start];
            array[start] = array[best];
            array[best] = temp;
        }
    }

    public void insertionSort(int[] array) {
        // Gehe über Array
        for (int i = 0; i < array.length; i++) {
            // Gehe über größer werdende Abschnitte des Arrays
            for (int j = 0; j < i; j++) {
                // Tausche Elemente, wenn das letzte Element kleiner als des erste ist
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = { 3, 4, 2, 1, 4, 5 };
        // insertionSort(array);
        // selectionSort(array);
        sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}