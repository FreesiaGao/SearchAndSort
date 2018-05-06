package search;

public class OrderSearch implements Search {
    @Override
    public int search(int[] A, int key) {
        if (A != null && A.length > 0) {
            for (int i=0; i<A.length; i++) {
                if (A[i] == key)
                    return i;
            }
        }
        return -1;
    }
}
