package sort;

public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 1)
            recursiveQuickSort(A, 0, A.length-1);
        return A;
    }

    private void recursiveQuickSort(int[] A, int p, int q) {
        if (p < q) {
            int r = patition(A, p, q);
            recursiveQuickSort(A, p, r-1);
            recursiveQuickSort(A, r+1, q);
        }
    }

    private int patition(int[] A, int p, int q) {
        while (p < q) {
            while (p < q && A[q] >= A[p])
                --q;
            int temp = A[p];
            A[p] = A[q];
            A[q] = temp;
            while (p < q && A[p] <= A[q])
                ++p;
            temp = A[p];
            A[p] = A[q];
            A[q] = temp;
        }
        return q;
    }

    public static void main(String[] args) {
        int[] A = {23, 12, 34, 24, 35, 67, 11, 23, 33, 45};
        QuickSort quickSort = new QuickSort();
        A = quickSort.sort(A);
        for (int i=0; i<A.length; i++)
            System.out.print(A[i]+" ");
    }
}
