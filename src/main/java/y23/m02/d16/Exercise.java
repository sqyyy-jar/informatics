package y23.m02.d16;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import java.util.Arrays;
import java.util.stream.IntStream;

@Page("16.02.2023/2")
public class Exercise {
    @Entrypoint
    public static void main() {
        int[] array = IntStream.range(0, 21).toArray();

        // 1.
        for (int i : array) {
            System.out.println(i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }

        // 2.
        int[] temperatures = {12, 14, 9, 12, 15, 16, 15, 12, 11, 8, 13, 13, 15, 12};
        int max = temperatures[0];
        int min = temperatures[0];
        int sum = 0;
        for (int temperature : temperatures) {
            if (temperature > max) {
                max = temperature;
            }
            if (temperature < min) {
                min = temperature;
            }
            sum += temperature;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println("Avarage: " + ((double) sum / temperatures.length));

        // 3.
        int[][] matrix = new int[10][10];
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                matrix[y - 1][x - 1] = x * y;
                System.out.printf("%4d", x * y);
            }
            System.out.println();
        }
    }
}
