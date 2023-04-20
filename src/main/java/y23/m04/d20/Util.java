package y23.m04.d20;

import java.util.Objects;

public class Util {
    public static String[] filterDuplicates(String[] array) {
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
                if (!Objects.equals(array[i], array[j])) {
                    continue;
                }
                bitset[j >> 6] |= 1L << (j & 63);
            }
        }
        String[] newArray = new String[uniqueCount];
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
}
