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


        // ----------------------------------
// 6️⃣ isEmpty()
// ----------------------------------
        boolean empty = set.isEmpty();
// Time: O(1)
// Space: O(1)

// ----------------------------------
// 7️⃣ clear()
// ----------------------------------
        set.clear();
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

// Reinsert elements
        set.add(5);
        set.add(15);
        set.add(25);
        set.add(35);
        set.add(45);

// ----------------------------------
// 8️⃣ first() & last()
// ----------------------------------
        int first = set.first();
        int last = set.last();
/*
Time Complexity: O(log n)
*/

// ----------------------------------
// 9️⃣ higher(), lower()
// ----------------------------------
        Integer higher = set.higher(25); // strictly greater
        Integer lower = set.lower(25);   // strictly smaller
/*
Time Complexity: O(log n)
*/

// ----------------------------------
// 🔟 ceiling(), floor()
// ----------------------------------
        Integer ceil = set.ceiling(26);  // >= element
        Integer floor = set.floor(26);   // <= element
/*
Time Complexity: O(log n)
*/


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