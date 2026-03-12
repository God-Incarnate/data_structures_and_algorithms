package algorithms.searching;

import java.util.HashSet;

public class HashSearch {

    // Returns true if target exists in array
    public static boolean hashSearch(int[] arr, int target) {

        // Step 1: Create HashSet
        HashSet<Integer> set = new HashSet<>();

        // Step 2: Insert all elements into HashSet
        for (int num : arr) {
            set.add(num);   // O(1) average per insertion
        }

        // Step 3: Check if target exists
        return set.contains(target);  // O(1) average
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 5, 80, 30};
        int target = 80;

        if (hashSearch(arr, target)) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element Not Found");
        }
    }
}
// OPTIMIZED Hash SEARCH:::::::::::::::::::::::::::::::
/*
import java.util.HashSet;

public class OptimizedHashSearch {

    static HashSet<Integer> set = new HashSet<>();

    // Build hash only once
    public static void buildHash(int[] arr) {
        for (int num : arr) {
            set.add(num);
        }
    }

    // Search many times in O(1)
    public static boolean search(int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {

        int[] arr = {10, 25, 5, 80, 30};

        buildHash(arr);  // O(n) one-time cost

        System.out.println(search(25)); // O(1)
        System.out.println(search(100)); // O(1)
    }
}
*/
