package data_structures.collection_framework.list;

import java.util.*;

public class LinkedListOp {
    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE LINKEDLIST
        // =====================================================
        LinkedList<Integer> list = new LinkedList<>();
        // Time: O(1)
        // Space: O(1)

        LinkedList<Integer> listFromCollection =
                new LinkedList<>(Arrays.asList(1, 2, 3));
        // Time: O(n)
        // Space: O(n)


        // =====================================================
        // 2. ADD ELEMENTS
        // =====================================================
        list.add(10);          // O(1)
        list.add(20);          // O(1)
        list.addFirst(5);      // O(1)
        list.addLast(30);      // O(1)

        list.add(1, 15);
        // Time: O(n) traverse to index
        // Space: O(1)

        list.addAll(listFromCollection);
        // Time: O(n+m)


    }
}

/*
🔹 Basic Operations
| Operation                   | Time |
| --------------------------- | ---- |
| addFirst(), addLast()       | O(1) |
| removeFirst(), removeLast() | O(1) |
| get(index)                  | O(n) |
| set(index)                  | O(n) |
| contains()                  | O(n) |
| indexOf()                   | O(n) |

🔹 Queue/Deque Operations
| Operation    | Time |
| ------------ | ---- |
| offer()      | O(1) |
| poll()       | O(1) |
| peek()       | O(1) |
| push()/pop() | O(1) |
| Operation    | Time |
| ------------ | ---- |

🔹 Sorting
| Operation          | Time       |
| ------------------ | ---------- |
| Collections.sort() | O(n log n) |

 */
