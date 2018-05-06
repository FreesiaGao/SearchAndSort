package sort;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 1)
            recursiveMergeSort(A, 0, A.length-1);
        return A;
    }

    private void recursiveMergeSort(int[] A, int p, int q) {
        if (p < q) {
            int m = (p + q) / 2;
            recursiveMergeSort(A, p, m);
            recursiveMergeSort(A, m+1, q);
            merge(A, p, m, q);
        }
    }

    private void merge(int[] A, int p, int m, int q) {
        int[] B = new int[q-p+1];
        int i = p;
        int j = m+1;
        int k = 0;
        while (i <= m && j <= q) {
            if (A[i] < A[j])
                B[k++] = A[i++];
            else
                B[k++] = A[j++];
        }
        while (i <= m)
            B[k++] = A[i++];
        while (j <= q)
            B[k++] = A[j++];
        for (int t=0; t<B.length; t++) {
            A[p+t]= B[t];
        }
    }
}
