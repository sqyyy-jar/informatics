package y24.m02.d09;

import java.util.Arrays;

public class ArrayStats {
    private final int[] array;
    private int reads = 0;
    private int writes = 0;
    private int comps = 0;

    public ArrayStats(int... array) {
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

    public void incComps() {
        this.comps++;
    }

    public int getReads() {
        return reads;
    }

    public int getWrites() {
        return writes;
    }

    public int getComps() {
        return comps;
    }

    public int[] unwrap() {
        return this.array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
