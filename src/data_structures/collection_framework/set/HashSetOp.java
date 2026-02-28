package data_structures.collection_framework.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetOp {
    public static void main(String[] args) {

        /*
        HashSet internally uses HashMap

        ✔ Unique elements only
        ✔ No order guarantee
        ✔ Allows one null
        ✔ Not thread-safe

        Average Time Complexity of basic operations = O(1)
        Worst case (collisions) = O(n)

        Space Complexity = O(n)
        */

        // ----------------------------------
        // 1️⃣ Create HashSet
        // ----------------------------------
        HashSet<Integer> set = new HashSet<>();

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
            Worst = O(n) (many hash collisions)

        Space Complexity: O(1) per element
        */

        System.out.println("Set: " + set);


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
| size()     | O(1)         | O(1)       |
| iteration  | O(n)         | O(n)       |
| clear()    | O(n)         | O(n)       |
| addAll()   | O(m)         | O(m)       |


| Feature      | HashSet    | LinkedHashSet      | TreeSet        |
| ------------ | ---------- | ------------------ | -------------- |
| Order        | No order   | Insertion order    | Sorted         |
| Speed        | Fastest    | Slightly slower    | Slowest        |
| Null allowed | Yes        | Yes                | No             |
| Structure    | Hash table | Hash + Linked list | Red-Black Tree |

 */
