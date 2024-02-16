package y24.m02.d09;

import java.util.Arrays;

public class ObservedArray {
    private final int[] array;
    private int reads = 0;
    private int writes = 0;

    public ObservedArray(int... array) {
        this.array = array;
    }

    public int get(int index) {
        reads++;
        return this.array[index];
    }

    public void set(int index, int value) {
        writes++;
        this.array[index] = value;
    }

    public int len() {
        return this.array.length;
    }

    public int getReads() {
        return reads;
    }

    public int getWrites() {
        return writes;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
