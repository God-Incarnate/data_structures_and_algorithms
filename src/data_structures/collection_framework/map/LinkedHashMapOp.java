package data_structures.collection_framework.map;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapOp {
    public static void main(String[] args) {

        /*
        LinkedHashMap = HashMap + Doubly Linked List

        ✔ Maintains insertion order (or access order if configured)
        ✔ Allows one null key and multiple null values
        ✔ Slightly slower than HashMap due to linked list overhead

        Internal Structure:
        Hash Table + Doubly Linked List

        Average Time Complexity for most operations = O(1)
        Worst Case = O(n) (when hash collisions happen)

        Space Complexity = O(n) (stores all elements + linked list pointers)
        */

        // -------------------------------
        // 1️⃣ Create LinkedHashMap
        // -------------------------------
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        /*
        Time Complexity: O(1)
        Space Complexity: O(1)
        */


        // -------------------------------
        // 2️⃣ put(key, value)
        // Insert element
        // -------------------------------
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");

        /*
        Average Time Complexity: O(1)
        Worst Case: O(n) if many collisions
        Space Complexity: O(1) per insert

        Adds element and keeps insertion order.
        If key already exists → value is updated.
        */


        // -------------------------------
        // 3️⃣ get(key)
        // -------------------------------
        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        /*
        Average Time Complexity: O(1)
        Worst Case: O(n)
        Space Complexity: O(1)

        Retrieves value for key.
        */


        // -------------------------------
        // 4️⃣ containsKey(key)
        // -------------------------------
        boolean hasKey = map.containsKey(3);

        /*
        Average Time Complexity: O(1)
        Worst Case: O(n)
        Space Complexity: O(1)
        */


        // -------------------------------
        // 5️⃣ containsValue(value)
        // -------------------------------
        boolean hasValue = map.containsValue("Apple");

        /*
        Time Complexity: O(n)
        Space Complexity: O(1)

        Because values are not hashed.
        Must scan entire map.
        */


        // -------------------------------
        // 6️⃣ remove(key)
        // -------------------------------
        map.remove(1);

        /*
        Average Time Complexity: O(1)
        Worst Case: O(n)
        Space Complexity: O(1)

        Removes key and fixes linked list order.
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

Removes all entries.
*/


// Reinsert for next examples
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");


// -------------------------------
// 🔟 keySet()
// -------------------------------
        Set<Integer> keys = map.keySet();

/*
Time Complexity: O(1)
Space Complexity: O(1)

Returns view of keys.
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
// 1️⃣3️⃣ Iterate LinkedHashMap
// -------------------------------
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

/*
Time Complexity: O(n)
Space Complexity: O(1)

Iterates in insertion order.
*/


// -------------------------------
// 1️⃣4️⃣ putIfAbsent()
// -------------------------------
        map.putIfAbsent(2, "Z");

/*
Average Time Complexity: O(1)
Space Complexity: O(1)

Adds only if key not present.
*/


// -------------------------------
// 1️⃣5️⃣ replace()
// -------------------------------
        map.replace(3, "C", "NewC");

/*
Average Time Complexity: O(1)
Space Complexity: O(1)
*/


// -------------------------------
// 1️⃣6️⃣ Access-order LinkedHashMap
// Used for LRU Cache
// -------------------------------
        LinkedHashMap<Integer, String> accessMap =
                new LinkedHashMap<>(16, 0.75f, true);

        accessMap.put(1, "One");
        accessMap.put(2, "Two");
        accessMap.get(1); // moves key 1 to end

/*
Time Complexity: O(1)
Space Complexity: O(n)

Access-order keeps recently used items last.
Useful for LRU cache.
*/

        System.out.println(accessMap);


    }
}
/*
| Feature     | TreeMap        | LinkedHashMap                |
| ----------- | -------------- | ---------------------------- |
| Order       | Sorted by key  | Insertion order              |
| Structure   | Red-Black Tree | HashMap + Doubly Linked List |
| put/get     | O(log n)       | O(1)                         |
| Null Key    | ❌ Not allowed  | ✔ Allowed                    |
| Thread-safe | ❌              | ❌                            |


| Operation       | Time Complexity       | Space |
| --------------- | --------------------- | ----- |
| put()           | O(1) avg / O(n) worst | O(1)  |
| get()           | O(1) avg / O(n) worst | O(1)  |
| remove()        | O(1) avg / O(n) worst | O(1)  |
| containsKey()   | O(1) avg              | O(1)  |
| containsValue() | O(n)                  | O(1)  |
| iteration       | O(n)                  | O(1)  |
| clear()         | O(n)                  | O(1)  |

 */