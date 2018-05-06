package sort;

public class ShellSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A != null && A.length > 1) {
            int d = (int)Math.ceil(A.length/2);
            while (d >= 1) {
                shellInsertSort(A, d);
                if (d/2 >= 1)
                    d = (int)Math.ceil(d/2);
                else    // 防止d=1以后跳不出来
                    d = d/2;
            }
        }
        return A;
    }

    private void shellInsertSort(int[] A, int d) {
        for (int i=d; i<A.length; i++) {
            int j = i-d;
            int key = A[i];
            while (j >= 0 && A[j] > key) {
                A[j+d] = A[j];
                j -= d;
            }
            A[j+d] = key;
        }
    }
}


