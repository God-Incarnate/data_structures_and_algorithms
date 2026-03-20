package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {2, 4, 6, 3, 2, 1, 7, 5, 9};

    static void main(String[] args) {

        quickSort(0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int low,int high) {
        if( low<high){
            int pi=partition(low,high);
            quickSort(low,pi-1);
            quickSort(pi+1,high);
        }
    }
    public static void swap(int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static int partition(int low,int high) {
        int pivot = arr[high];
        int i=low-1;

        for (int j = low;j<high;j++){
            if(arr[j]<pivot) {
                i++;
                swap(i,j);
            }
        }
        swap(i+1,high);
        return i+1;
    }

}
