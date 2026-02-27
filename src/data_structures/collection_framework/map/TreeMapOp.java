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
        // -------------------------------
        // 4️⃣ containsKey(key)
        // -------------------------------
        boolean hasKey = map.containsKey(1);

    /*
    Time Complexity: O(log n)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 5️⃣ containsValue(value)
        // -------------------------------
        boolean hasValue = map.containsValue("Apple");

    /*
    Time Complexity: O(n)
    Must scan all nodes.
    Space Complexity: O(1)
    */


        // -------------------------------
        // 6️⃣ remove(key)
        // -------------------------------
        map.remove(3);

    /*
    Time Complexity: O(log n)
    Tree re-balancing needed.
    Space Complexity: O(1)
    */


        // -------------------------------
        // 7️⃣ size()
        // -------------------------------
        int size = map.size();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 8️⃣ isEmpty()
        // -------------------------------
        boolean empty = map.isEmpty();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 9️⃣ clear()
        // -------------------------------
        map.clear();

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
    */

        // Reinsert values
        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");

        // -------------------------------
        // 🔟 keySet()
        // -------------------------------
        Set<Integer> keys = map.keySet();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 1️⃣1️⃣ values()
        // -------------------------------
        Collection<String> values = map.values();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 1️⃣2️⃣ entrySet()
        // -------------------------------
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

    /*
    Time Complexity: O(1)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 1️⃣3️⃣ Iterate TreeMap
        // -------------------------------
        for (
                Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)

    Iteration is in sorted key order.
    */
        // -------------------------------
        // 1️⃣4️⃣ firstKey(), lastKey()
        // -------------------------------
        int first = map.firstKey();
        int last = map.lastKey();

    /*
    Time Complexity: O(log n)
    */


        // -------------------------------
        // 1️⃣5️⃣ higherKey(), lowerKey()
        // -------------------------------
        Integer higher = map.higherKey(20); // next bigger
        Integer lower = map.lowerKey(20);   // next smaller

    /*
    Time Complexity: O(log n)
    */


        // -------------------------------
        // 1️⃣6️⃣ ceilingKey(), floorKey()
        // -------------------------------
        Integer ceil = map.ceilingKey(25); // >= key
        Integer floor = map.floorKey(25);  // <= key

    /*
    Time Complexity: O(log n)
    */


        // -------------------------------
        // 1️⃣7️⃣ subMap(), headMap(), tailMap()
        // -------------------------------
        Map<Integer, String> sub = map.subMap(10, 30);
        Map<Integer, String> head = map.headMap(30);
        Map<Integer, String> tail = map.tailMap(20);

    /*
    Time Complexity: O(log n)
    Space Complexity: O(1)
    Views of map.
    */


        // -------------------------------
        // 1️⃣8️⃣ putIfAbsent()
        // -------------------------------
        map.putIfAbsent(20, "Z");

    /*
    Time Complexity: O(log n)
    Space Complexity: O(1)
    */


        // -------------------------------
        // 1️⃣9️⃣ replace()
        // -------------------------------
        map.replace(40, "D", "NewD");

    /*
    Time Complexity: O(log n)
    Space Complexity: O(1)
    */

        System.out.println("Final Map: " + map);


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
