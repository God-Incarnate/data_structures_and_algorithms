package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    static int[] arr={2,4,6,3,2,1,7,5,9};

    static void main(String[] args){
        insertionSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(){
        for (int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
