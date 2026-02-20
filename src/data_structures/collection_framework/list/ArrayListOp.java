package data_structures.collection_framework.list;

import java.util.*;

public class ArrayListOp {
    public static void main(String[] args) {

        // =========================================================
        // 1. CREATE ARRAYLIST
        // =========================================================

        ArrayList<Integer> list = new ArrayList<>();
        // Time Complexity: O(1)
        // Space Complexity: O(1) initially (default capacity allocated lazily)

        ArrayList<Integer> listWithCapacity = new ArrayList<>(100);
        // Time Complexity: O(n) to allocate array of size n
        // Space Complexity: O(n)

        // =========================================================
        // 2. ADD ELEMENTS
        // =========================================================

        list.add(10);
        // Time: O(1) amortized (occasionally O(n) during resize)
        // Space: O(1)

        list.add(20);
        list.add(30);

        list.add(1, 15);
        // Time: O(n) because elements must shift right
        // Space: O(1)

        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(100);
        anotherList.add(200);

        list.addAll(anotherList);
        // Time: O(n + m)
        // Space: O(m) new elements added

        // =========================================================
        // 3. ACCESS ELEMENT
        // =========================================================

        int val = list.get(2);
        // Time: O(1) direct array access
        // Space: O(1)


        // =========================================================
        // 4. UPDATE ELEMENT
        // =========================================================

        list.set(2, 999);
        // Time: O(1)
        // Space: O(1)


        // =========================================================
        // 5. REMOVE ELEMENT
        // =========================================================

        list.remove(1);
        // Time: O(n) shift elements left
        // Space: O(1)

        list.remove(Integer.valueOf(30));
        // Time: O(n) search + shift
        // Space: O(1)

        list.clear();
        // Time: O(n) null all references
        // Space: O(1)

        // =========================================================
        // 6. SEARCH OPERATIONS
        // =========================================================

        list.add(5);
        list.add(10);
        list.add(15);

        boolean hasTen = list.contains(10);
        // Time: O(n) linear search
        // Space: O(1)

        int index = list.indexOf(15);
        // Time: O(n)
        // Space: O(1)

        int lastIndex = list.lastIndexOf(10);
        // Time: O(n)
        // Space: O(1)


        // =========================================================
        // 7. ITERATION
        // =========================================================

        for (int num : list) {
            System.out.print(num + " ");
        }
        // Time: O(n)
        // Space: O(1)

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // Time: O(n)
        // Space: O(1)


        // =========================================================
        // 8. SORTING
        // =========================================================

        Collections.sort(list);
        // Time: O(n log n) (TimSort)
        // Space: O(log n)

        list.sort(null);
        // Same complexity

        // =========================================================
        // 9. COPYING / CONVERSION
        // =========================================================

        ArrayList<Integer> copy = new ArrayList<>(list);
        // Time: O(n)
        // Space: O(n)

        Object[] arr = list.toArray();
        // Time: O(n)
        // Space: O(n)

        ArrayList<Integer> cloned = (ArrayList<Integer>) list.clone();
        // Time: O(n)
        // Space: O(n)


        // =========================================================
        // 10. CAPACITY OPERATIONS
        // =========================================================

        list.ensureCapacity(50);
        // Time: O(n) if resize happens
        // Space: O(n)

        list.trimToSize();
        // Time: O(n)
        // Space: O(n)


        // =========================================================
        // 11. BULK OPERATIONS
        // =========================================================

        ArrayList<Integer> removeList = new ArrayList<>();
        removeList.add(10);

        list.removeAll(removeList);
        // Time: O(n * m)
        // Space: O(1)

        list.retainAll(removeList);
        // Time: O(n * m)
        // Space: O(1)

        list.containsAll(removeList);
        // Time: O(n * m)
        // Space: O(1)


        // =========================================================
        // 12. IMPORTANT INTERVIEW PROGRAMS
        // =========================================================

        // Reverse ArrayList → O(n)
        Collections.reverse(list);

        // Find max → O(n)
        int max = Collections.max(list);

        // Remove duplicates → O(n)
        ArrayList<Integer> dup = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4));
        Set<Integer> unique = new HashSet<>(dup);

        // Frequency count → O(n)
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : dup)
            freq.put(num, freq.getOrDefault(num, 0) + 1);


        // =========================================================
        // PRINT OUTPUT
        // =========================================================
        System.out.println("\nList: " + list);
        System.out.println("Max Element: " + max);
        System.out.println("Unique Elements: " + unique);
        System.out.println("Frequency Map: " + freq);

    }
}
/*
| Operation     | Time Complexity | Space    |
| ------------- | --------------- | -------- |
| add(e)        | O(1)*           | O(1)     |
| add(index)    | O(n)            | O(1)     |
| get()         | O(1)            | O(1)     |
| set()         | O(1)            | O(1)     |
| remove(index) | O(n)            | O(1)     |
| contains()    | O(n)            | O(1)     |
| sort()        | O(n log n)      | O(log n) |
| copy/clone    | O(n)            | O(n)     |
| iteration     | O(n)            | O(1)     |

*/
