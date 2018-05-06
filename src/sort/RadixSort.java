package sort;

import java.util.Arrays;

public class RadixSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 0) {
            sort(A, 10);
        }
        return A;
    }

    private int[] sort(int[] A, int radix) {
        if (A != null && A.length > 0) {
            int[] temp = new int[A.length];
            int[] buckets = new int[radix];
            int rate = 1;
            int d = 0;
            for (int num:A) {
                int len = String.valueOf(num).length();
                if (len > d)
                    d = len;
            }

            for (int i=0; i<d; i++) {
                Arrays.fill(buckets, 0);
                System.arraycopy(A, 0, temp, 0, A.length);
                for (int j=0; j<temp.length; j++) {
                    int key = (temp[j]/rate) % radix;
                    buckets[key]++;
                }
                for (int j=1; j<buckets.length; j++) {
                    buckets[j] += buckets[j-1];
                }
                for (int j=temp.length-1; j>-1; j--) {
                    int key = (temp[j]/rate) % radix;
                    A[--buckets[key]] = temp[j];
                }
                rate *= radix;
            }
        }
        return A;
    }
}
