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

        // -------------------------------
        // 2. BASIC METHODS
        // -------------------------------
        String s = "  Java Programming  ";

        int len = s.length();             // O(1) time, O(1) space
        char ch = s.charAt(2);            // O(1) time, O(1) space
        boolean empty = s.isEmpty();      // O(1) time, O(1) space
        String trimmed = s.trim();        // O(n) time, O(n) space
        String lower = s.toLowerCase();   // O(n) time, O(n) space
        String upper = s.toUpperCase();   // O(n) time, O(n) space


        // -------------------------------
        // 3. STRING COMPARISON
        // -------------------------------
        String a = "Java";
        String b = "java";

        boolean eq = a.equals(b);               // O(n) time, O(1) space
        boolean eqIgnore = a.equalsIgnoreCase(b); // O(n) time
        int cmp = a.compareTo(b);               // O(n) time


        // -------------------------------
        // 4. SEARCHING
        // -------------------------------
        boolean contains = s.contains("gram"); // O(n*m) worst case
        int index = s.indexOf("g");            // O(n)
        int lastIndex = s.lastIndexOf("g");    // O(n)
        boolean start = s.startsWith("  J");   // O(m)
        boolean end = s.endsWith("ing  ");     // O(m)

        // -------------------------------
        // 5. SUBSTRING
        // -------------------------------
        String sub1 = s.substring(2);      // O(n)
        String sub2 = s.substring(2, 6);   // O(n)


        // -------------------------------
        // 6. MODIFYING STRINGS
        // -------------------------------
        String replaced = s.replace("a", "x");     // O(n)
        String replacedAll = s.replaceAll("a", "x"); // O(n) + regex cost
        String concat = a.concat(" Rocks");        // O(n+m)
        String joined = String.join("-", "A","B","C"); // O(total length)
    }
}
