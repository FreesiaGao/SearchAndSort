package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IndexSearch implements Search {
    @Override
    public int search(int[] A, int key) {
        if (A != null && A.length > 0) {
            int indexRule = 10;
            ArrayList<IndexItem> indexItems = buildIndexArray(A, indexRule);
            IndexItem item = null;
            for (int i=0; i<indexItems.size(); i++) {
                if (key/indexRule == indexItems.get(i).index) {
                    item = indexItems.get(i);
                    break;
                }
            }

            if (item != null) {
                for (int i=item.start; i<item.start+item.length; i++) {
                    if (A[i] == key)
                        return i;
                }
            }
        }
        return -1;
    }

    public int search(int[]A, int key, int indexRule) {
        if (A != null && A.length > 0) {
            ArrayList<IndexItem> indexItems = buildIndexArray(A, indexRule);
            IndexItem item = null;
            for (int i=0; i<indexItems.size(); i++) {
                if (key/indexRule == indexItems.get(i).index) {
                    item = indexItems.get(i);
                    break;
                }
            }

            if (item != null) {
                for (int i=item.start; i<item.start+item.length; i++) {
                    if (A[i] == key)
                        return i;
                }
            }
        }
        return -1;
    }

    private ArrayList<IndexItem> buildIndexArray(int[] A, int indexRule) {
        ArrayList<IndexItem> itemArray = new ArrayList<>();
        for (int i=0; i<A.length; i++) {
            int index = A[i] / indexRule;
            if (itemArray.size() == 0 || itemArray.get(itemArray.size()-1).index != index) {
                IndexItem item = new IndexItem(index, i, 1);
                itemArray.add(item);
            } else {
                itemArray.get(itemArray.size()-1).length++;
            }
        }
        return itemArray;
    }

    private class IndexItem implements Comparable<IndexItem> {
        public int index;
        public int start;
        public int length;

        public IndexItem(int index, int start, int length) {
            this.index = index;
            this.start = start;
            this.length = length;
        }

        @Override
        public int compareTo(IndexItem o) {
            if (this.index > o.index)
                return 1;
            else
                return -1;
        }
    }
}
