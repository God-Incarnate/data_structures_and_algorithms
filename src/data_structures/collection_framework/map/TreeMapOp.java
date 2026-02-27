package data_structures.collection_framework.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapOp {
    public static void main(String[] args) {
    /*
        TreeMap uses Red-Black Tree (Self-balancing BST)

        ✔ Keys sorted automatically
        ✔ No null key allowed
        ✔ Slower than HashMap but ordered

        Time Complexity of most operations = O(log n)
        Space Complexity = O(n)
        */

        // -------------------------------
        // 1️⃣ Create TreeMap
        // -------------------------------
        TreeMap<Integer, String> map = new TreeMap<>();

        /*
        Time Complexity: O(1)
        Space Complexity: O(1)
        */


        // -------------------------------
        // 2️⃣ put(key, value)
        // Insert element
        // -------------------------------
        map.put(3, "Mango");
        map.put(1, "Apple");
        map.put(2, "Banana");

        /*
        Time Complexity: O(log n)
        Because tree balancing is needed.

        Space Complexity: O(1) per insert
        */

        System.out.println("Sorted Map: " + map);


        // -------------------------------
        // 3️⃣ get(key)
        // -------------------------------
        String val = map.get(2);

        /*
        Time Complexity: O(log n)
        Space Complexity: O(1)
        */


    }
}

/*
| Operation        | Time Complexity |
| ---------------- | --------------- |
| put()            | O(log n)        |
| get()            | O(log n)        |
| remove()         | O(log n)        |
| containsKey()    | O(log n)        |
| containsValue()  | O(n)            |
| iteration        | O(n)            |
| firstKey/lastKey | O(log n)        |
| subMap/headMap   | O(log n)        |
| clear()          | O(n)            |

 */
