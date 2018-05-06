package search;

public class BinarySearch implements Search {
    @Override
    public int search(int[] A, int key) {
        if (A != null && A.length > 0) {
            int left = 0;
            int right = A.length-1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (A[middle] == key) {
                    return middle;
                } else if (A[middle] != key && left == right) {
                    break;
                } else if (A[middle] > key) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
}
