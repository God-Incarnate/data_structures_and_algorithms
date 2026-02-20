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

        // =========================================================
        // 2. ADD ELEMENTS
        // =========================================================

        list.add(10);
        // Time: O(1) amortized (occasionally O(n) during resize)
        // Space: O(1)

        list.add(20);
        list.add(30);

        list.add(1, 15);
        // Time: O(n) because elements must shift right
        // Space: O(1)

        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(100);
        anotherList.add(200);

        list.addAll(anotherList);
        // Time: O(n + m)
        // Space: O(m) new elements added

        // =========================================================
        // 3. ACCESS ELEMENT
        // =========================================================

        int val = list.get(2);
        // Time: O(1) direct array access
        // Space: O(1)


        // =========================================================
        // 4. UPDATE ELEMENT
        // =========================================================

        list.set(2, 999);
        // Time: O(1)
        // Space: O(1)


        // =========================================================
        // 5. REMOVE ELEMENT
        // =========================================================

        list.remove(1);
        // Time: O(n) shift elements left
        // Space: O(1)

        list.remove(Integer.valueOf(30));
        // Time: O(n) search + shift
        // Space: O(1)

        list.clear();
        // Time: O(n) null all references
        // Space: O(1)

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
