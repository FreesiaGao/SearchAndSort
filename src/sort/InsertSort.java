package sort;

public class InsertSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 1) {
            for (int i=2; i<A.length; i++) {
                int j = i-1;
                int key = A[i];
                while (j >= 0 && A[j] > key) {
                    A[j+1] = A[j];
                    j--;
                }
                A[j+1] = key;
            }
        }
        return A;
    }
}
