package sort;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 1) {
            for (int i=0; i<A.length-1; i++) {
                for (int j=A.length-1; j>i; j--) {
                    if (A[j] < A[j-1]) {
                        int temp = A[j];
                        A[j] = A[j-1];
                        A[j-1] = temp;
                    }
                }
            }
        }
        return A;
    }
}
