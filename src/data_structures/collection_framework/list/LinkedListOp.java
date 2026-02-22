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

        // =====================================================
        // 3. ACCESS ELEMENT
        // =====================================================
        int val = list.get(2);
        // Time: O(n)
        // Space: O(1)

        list.getFirst();  // O(1)
        list.getLast();   // O(1)


        // =====================================================
        // 4. UPDATE ELEMENT
        // =====================================================
        list.set(2, 100);
        // Time: O(n)


        // =====================================================
        // 5. REMOVE ELEMENT
        // =====================================================
        list.remove();          // O(1) remove first
        list.removeFirst();     // O(1)
        list.removeLast();      // O(1)

        list.remove(1);
        // Time: O(n) traverse

        list.remove(Integer.valueOf(20));
        // Time: O(n) search

        list.clear();           // O(n)

        // =====================================================
        // 6. SEARCHING
        // =====================================================
        list.add(10);
        list.add(20);
        list.add(30);

        boolean has20 = list.contains(20);
        // Time: O(n)

        int index = list.indexOf(30);
        // Time: O(n)


        // =====================================================
        // 7. ITERATION
        // =====================================================
        for(int num : list) {   // O(n)
            System.out.print(num + " ");
        }

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {   // O(n)
            System.out.print(it.next() + " ");
        }


        // =====================================================
        // 8. QUEUE OPERATIONS (Deque methods)
        // =====================================================
        list.offer(40);     // O(1)
        list.offerFirst(5); // O(1)
        list.offerLast(50); // O(1)

        list.poll();        // O(1)
        list.peek();        // O(1)

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
