package algorithms.searching;

public class LinearSearch {
    // Method to perform linear search
    public static int linearSearch(int[] arr, int target) {

        // Traverse entire array
        for (int i = 0; i < arr.length; i++) {

            // If element found, return index
            if (arr[i] == target) {
                return i;  // O(1)
            }
        }

        // If element not found
        return -1;
    }

    static void main(String[] args) {

        int[] arr = {10, 25, 5, 80, 30};
        int target = 80;

        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
