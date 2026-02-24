package data_structures.collection_framework.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapOp {
    public static void main(String[] args) {

        // =====================================================
        // 1. CREATE HASHMAP
        // =====================================================
        HashMap<String, Integer> map = new HashMap<>();
        // Time: O(1)
        // Space: O(1)

        HashMap<String, Integer> mapWithCapacity =
                new HashMap<>(100);
        // Time: O(n) allocate buckets
        // Space: O(n)


        // =====================================================
        // 2. ADD ELEMENTS
        // =====================================================
        map.put("A", 1);
        // Time: O(1) average, O(n) worst (resize/collision)
        // Space: O(1)

        map.put("B", 2);
        map.put("C", 3);

        map.put("A", 100);
        // Update existing key → O(1)


        // =====================================================
        // 3. ACCESS ELEMENT
        // =====================================================
        int val = map.get("A");
        // Time: O(1) average, O(log n) worst
        // Space: O(1)

        map.getOrDefault("X", 0);
        // Time: O(1)


        // =====================================================
        // 4. REMOVE ELEMENT
        // =====================================================
        map.remove("B");
        // Time: O(1) average

        map.remove("C", 3);
        // Time: O(1)

    }
}
/*
🔹 Basic Operations
| Operation       | Average | Worst    |
| --------------- | ------- | -------- |
| put()           | O(1)    | O(n)     |
| get()           | O(1)    | O(log n) |
| remove()        | O(1)    | O(log n) |
| containsKey()   | O(1)    | O(log n) |
| containsValue() | O(n)    | O(n)     |

🔹 Other Operations
| Operation | Time   |
| --------- | ------ |
| size()    | O(1)   |
| clear()   | O(n)   |
| putAll()  | O(n+m) |
| iteration | O(n)   |
| resize    | O(n)   |

Space = O(n)


| Feature  | HashMap | LinkedHashMap | TreeMap  |
| -------- | ------- | ------------- | -------- |
| Order    | No      | Insertion     | Sorted   |
| put/get  | O(1)    | O(1)          | O(log n) |
| Null key | Yes     | Yes           | No       |

 */