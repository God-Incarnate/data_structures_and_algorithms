package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    static int[] arr={2,4,6,3,2,1,7,5,9};

    static void main(String[] args) {
        mergeSort(0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int left,int right) {
        if (left<right) {
            int mid=left+(right-left)/2;
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            merge(left,mid,right);
        }
    }

    
}
