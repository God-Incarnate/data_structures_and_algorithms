package data_structures.collection_framework.set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetOp {
    public static void main(String[] args) {

        /*
        TreeSet:
        - Red-Black Tree based
        - Sorted order
        - Unique elements only
        - No null allowed

        Time Complexity:
        add(), remove(), contains() -> O(log n)
        iteration -> O(n)

        Space Complexity -> O(n)
        */

        // ----------------------------------
        // 1️⃣ Create TreeSet
        // ----------------------------------
        TreeSet<Integer> set = new TreeSet<>();
        // Time: O(1)
        // Space: O(1)

        // ----------------------------------
        // 2️⃣ add(element)
        // ----------------------------------
        set.add(30);
        set.add(10);
        set.add(20);
        set.add(40);
        set.add(10); // duplicate ignored

        /*
        Time Complexity: O(log n)
        Space Complexity: O(1) per element
        */

        System.out.println("Sorted Set: " + set);

        // ----------------------------------
        // 3️⃣ contains(element)
        // ----------------------------------
        boolean exists = set.contains(20);
        /*
        Time Complexity: O(log n)
        Space Complexity: O(1)
        */

        // ----------------------------------
        // 4️⃣ remove(element)
        // ----------------------------------
        set.remove(30);
        /*
        Time Complexity: O(log n)
        Space Complexity: O(1)
        */

        // ----------------------------------
        // 5️⃣ size()
        // ----------------------------------
        int size = set.size();
        // Time: O(1)
        // Space: O(1)


    }
}
/*
| Operation        | Time Complexity |
| ---------------- | --------------- |
| add()            | O(log n)        |
| remove()         | O(log n)        |
| contains()       | O(log n)        |
| first()/last()   | O(log n)        |
| higher()/lower() | O(log n)        |
| iteration        | O(n)            |
| clear()          | O(n)            |
| size()           | O(1)            |

 */