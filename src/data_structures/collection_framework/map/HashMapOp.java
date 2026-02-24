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

        // =====================================================
// 5. SEARCH OPERATIONS
// =====================================================
        map.containsKey("A");
// Time: O(1)

        map.containsValue(100);
// Time: O(n)


// =====================================================
// 6. ITERATION
// =====================================================
        for(String key : map.keySet()) {
            System.out.println(key);
        }
// Time: O(n)

        for(Integer value : map.values()) {
            System.out.println(value);
        }
// Time: O(n)

        for(Map.Entry<String,Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
// Time: O(n)


// =====================================================
// 7. SIZE & CLEAR
// =====================================================
        map.size();   // O(1)
        map.isEmpty();// O(1)
        map.clear();  // O(n)


// =====================================================
// 8. BULK OPERATIONS
// =====================================================
        HashMap<String,Integer> another = new HashMap<>();
        another.put("X",10);
        another.put("Y",20);

        map.putAll(another);
// Time: O(n+m)

        // =====================================================
// 9. COMPUTE METHODS
// =====================================================
        map.put("A",1);

        map.compute("A", (k,v) -> v==null?1:v+1);
// Time: O(1)

        map.computeIfAbsent("Z", k->5);
// Time: O(1)

        map.merge("A",1,Integer::sum);
// Time: O(1)


// =====================================================
// 10. IMPORTANT INTERVIEW PROGRAMS
// =====================================================

// Frequency count → O(n)
        int[] arr = {1,2,2,3,3,3};
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int num : arr)
            freq.put(num, freq.getOrDefault(num,0)+1);

// Find duplicates → O(n)
        for(int key : freq.keySet())
            if(freq.get(key) > 1)
                System.out.println("Duplicate: " + key);


// =====================================================
// PRINT OUTPUT
// =====================================================
        System.out.println("Map: " + map);
        System.out.println("Frequency Map: " + freq);

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