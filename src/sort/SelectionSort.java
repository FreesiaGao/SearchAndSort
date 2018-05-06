package sort;

public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 1) {
            for (int i=0; i<A.length-1; i++) {
                int min = i;
                for (int j=i+1; j<A.length; j++) {
                    if (A[j] < A[min])
                        min = j;
                }
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
        return A;
    }
}
