package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {2, 4, 6, 3, 2, 1, 7, 5, 9};

    static void main(String[] args) {

        quickSort(0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

}
