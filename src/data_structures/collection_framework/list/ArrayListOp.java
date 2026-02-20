package data_structures.collection_framework.list;

import java.util.*;

public class ArrayListOp {
    public static void main(String[] args) {

        // =========================================================
        // 1. CREATE ARRAYLIST
        // =========================================================

        ArrayList<Integer> list = new ArrayList<>();
        // Time Complexity: O(1)
        // Space Complexity: O(1) initially (default capacity allocated lazily)

        ArrayList<Integer> listWithCapacity = new ArrayList<>(100);
        // Time Complexity: O(n) to allocate array of size n
        // Space Complexity: O(n)



    }
}
/*
| Operation     | Time Complexity | Space    |
| ------------- | --------------- | -------- |
| add(e)        | O(1)*           | O(1)     |
| add(index)    | O(n)            | O(1)     |
| get()         | O(1)            | O(1)     |
| set()         | O(1)            | O(1)     |
| remove(index) | O(n)            | O(1)     |
| contains()    | O(n)            | O(1)     |
| sort()        | O(n log n)      | O(log n) |
| copy/clone    | O(n)            | O(n)     |
| iteration     | O(n)            | O(1)     |

*/
