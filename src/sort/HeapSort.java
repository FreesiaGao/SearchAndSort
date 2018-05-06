package sort;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] A) {
        if (A !=null && A.length > 1) {
            buildMaxHeap(A);
            int heapSize = A.length;
            for (int i=heapSize-1; i>0; i--) {
                int temp = A[i];
                A[i] = A[0];
                A[0] = temp;
                maxHeapity(A, 0, i);
            }
        }
        return A;
    }

    private void buildMaxHeap(int[] A) {
        for (int i=(A.length-1)/2-1; i>=0; i--)
            maxHeapity(A, i, A.length);
    }

    private void maxHeapity(int[] A, int node, int heapSize) {
        int temp = A[node];
        int child = 2*node+1;
        while (child < heapSize) {
            if (child+1 < heapSize && A[child] < A[child+1]) {
                child++;
            }
            if (A[node] < A[child]) {
                A[node] = A[child];
                node = child;
                child = 2*node+1;
            } else
                break;
            A[node] = temp;
        }
    }
}
