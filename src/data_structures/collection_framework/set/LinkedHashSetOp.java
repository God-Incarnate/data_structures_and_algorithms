package data_structures.collection_framework.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetOp {
    public static void main(String[] args) {

        /*
        LinkedHashSet Internals:
        HashSet + Doubly Linked List

        ✔ Unique elements only
        ✔ Maintains insertion order
        ✔ Allows one null
        ✔ Not thread-safe

        Average Time Complexity = O(1)
        Worst Case (hash collision) = O(n)
        Space Complexity = O(n)
        */

        // ----------------------------------
        // 1️⃣ Create LinkedHashSet
        // ----------------------------------
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        /*
        Time Complexity: O(1)
        Space Complexity: O(1)
        */


        // ----------------------------------
        // 2️⃣ add(element)
        // ----------------------------------
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // duplicate ignored

        /*
        Time Complexity:
            Average = O(1)
            Worst = O(n)

        Space Complexity: O(1) per element
        */

        System.out.println("Insertion Order Set: " + set);

        // ----------------------------------
        // 3️⃣ contains(element)
        // ----------------------------------
        boolean exists = set.contains(20);

    /*
    Time Complexity:
        Average = O(1)
        Worst = O(n)

    Space Complexity: O(1)
    */


        // ----------------------------------
        // 4️⃣ remove(element)
        // ----------------------------------
        set.remove(30);

    /*
    Time Complexity:
        Average = O(1)
        Worst = O(n)

    Space Complexity: O(1)
    */


        // ----------------------------------
        // 5️⃣ size()
        // ----------------------------------
        int size = set.size();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */


        // ----------------------------------
        // 6️⃣ isEmpty()
        // ----------------------------------
        boolean empty = set.isEmpty();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */

    }
}
/*
| Operation  | Average Time | Worst Time |
| ---------- | ------------ | ---------- |
| add()      | O(1)         | O(n)       |
| remove()   | O(1)         | O(n)       |
| contains() | O(1)         | O(n)       |
| iteration  | O(n)         | O(n)       |
| clear()    | O(n)         | O(n)       |
| size()     | O(1)         | O(1)       |

 */