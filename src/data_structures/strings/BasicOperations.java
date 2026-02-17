package data_structures.strings;

public class BasicOperations {
    public static void main(String[] args) {

        // -------------------------------
        // 1. STRING CREATION
        // -------------------------------
        String s1 = "Hello";              // O(1) time, O(1) space (String pool reuse)
        String s2 = new String("Hello");  // O(n) time, O(n) space (new object)

        char[] arr = {'H', 'i'};
        String s3 = new String(arr);      // O(n) time, O(n) space
    }
}
