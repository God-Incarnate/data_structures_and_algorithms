package data_structures.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasicOperations {
    public static void main(String[] args) {

        // ------------------------------------------------
        // 1. ARRAY CREATION
        // ------------------------------------------------
        int[] arr1 = new int[5];            // O(1) time, O(n) space
        int[] arr2 = {1, 2, 3, 4, 5};           // O(n) time, O(n) space


        // ------------------------------------------------
        // 2. ACCESS ELEMENT
        // ------------------------------------------------
        int x = arr2[2];                    // O(1) time, O(1) space


        // ------------------------------------------------
        // 3. UPDATE ELEMENT
        // ------------------------------------------------
        arr2[2] = 10;                       // O(1) time


        // ------------------------------------------------
        // 4. TRAVERSAL
        // ------------------------------------------------
        for (int i = 0; i < arr2.length; i++)      // O(n) time
            System.out.print(arr2[i] + " ");

        System.out.println();


        // ------------------------------------------------
        // 5. INSERTION
        // ------------------------------------------------
        // At end (if space exists) → O(1)
        int[] arr3 = new int[6];
        System.arraycopy(arr2, 0, arr3, 0, arr2.length); // O(n)
        arr3[5] = 99;

        // At middle → O(n)
        int pos = 2;
        int[] newArr = new int[arr2.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == pos) newArr[i] = 100;
            else newArr[i] = arr2[j++];
        }

        // ------------------------------------------------
        // 6. DELETION
        // ------------------------------------------------
        // Delete from middle → O(n)
        int delPos = 2;
        int[] afterDelete = new int[arr2.length-1];
        for(int i=0,j=0;i<arr2.length;i++){
            if(i!=delPos) afterDelete[j++]=arr2[i];
        }


        // ------------------------------------------------
        // 7. SEARCHING
        // ------------------------------------------------

        // Linear Search → O(n)
        int key = 4;
        boolean found = false;
        for(int num : arr2)
            if(num==key) found = true;

        // Binary Search → O(log n) (array must be sorted)
        Arrays.sort(arr2);                     // O(n log n)
        int index = Arrays.binarySearch(arr2, 4); // O(log n)


        // ------------------------------------------------
        // 8. SORTING
        // ------------------------------------------------
        Arrays.sort(arr2);                    // O(n log n)
        Arrays.parallelSort(arr2);            // O(n log n) multi-threaded


        // ------------------------------------------------
        // 9. COPYING ARRAYS
        // ------------------------------------------------
        int[] copy1 = Arrays.copyOf(arr2, arr2.length); // O(n)
        int[] copy2 = arr2.clone();                     // O(n)
        System.arraycopy(arr2,0,copy2,0,arr2.length);   // O(n)


        // ------------------------------------------------
        // 10. COMPARING ARRAYS
        // ------------------------------------------------
        boolean equal = Arrays.equals(arr2, copy1); // O(n)


        // ------------------------------------------------
        // 11. FILL ARRAY
        // ------------------------------------------------
        Arrays.fill(arr1, 5);                // O(n)


        // ------------------------------------------------
        // 12. 2D ARRAYS
        // ------------------------------------------------
        int[][] matrix = new int[3][3];      // O(n*m) space

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                matrix[i][j] = i+j;          // O(n*m)


        // ------------------------------------------------
        // 13. IMPORTANT INTERVIEW PROGRAMS
        // ------------------------------------------------

        // Reverse Array → O(n) time, O(1) space
        int[] rev = {1,2,3,4,5};
        for(int i=0;i<rev.length/2;i++){
            int temp = rev[i];
            rev[i] = rev[rev.length-1-i];
            rev[rev.length-1-i] = temp;
        }

        // Find Max → O(n)
        int max = arr2[0];
        for(int num : arr2)
            if(num > max) max = num;

        // Remove Duplicates (using Set) → O(n)
        int[] dup = {1,2,2,3,3,4};
        Set<Integer> set = new HashSet<>();
        for(int num : dup) set.add(num);

        // Prefix Sum → O(n)
        int[] prefix = new int[arr2.length];
        prefix[0] = arr2[0];
        for(int i=1;i<arr2.length;i++)
            prefix[i] = prefix[i-1] + arr2[i];


        // ------------------------------------------------
        // 14. PRINT OUTPUT
        // ------------------------------------------------
        System.out.println("Max Element: " + max);
        System.out.println("Binary Search Index of 4: " + index);
        System.out.println("Arrays Equal: " + equal);

    }
}
