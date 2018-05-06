import search.BinarySearch;
import search.IndexSearch;
import search.OrderSearch;
import search.Search;
import sort.*;

public class Test {
    public static void main(String[] args) {
        int[] A = {23, 12, 34, 24, 35, 67, 11, 23, 33, 45};
        Sort sort = new ShellSort();
        A = sort.sort(A);
        for (int i=0; i<A.length; i++)
            System.out.print(A[i]+" ");

        Search search = new IndexSearch();
        System.out.print("\n"+search.search(A, 24));
    }
}
