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