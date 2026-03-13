package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    static int[] arr={2,4,6,3,2,1,7,5,9};

    public static void bubbleSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean hasSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    hasSwapped = true;
                }

            }
            if (!hasSwapped) {
                break;
            }
        }
    }
}
