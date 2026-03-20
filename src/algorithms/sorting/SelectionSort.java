package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    static int[] arr={2,4,6,3,2,1,7,5,9};

    static void main(String[] args){

        selectionSort();
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(){
        int n=arr.length;

        for (int i=0;i<n;i++){
            int minIndex =i,j=i;
            while(j<n){
                if(arr[j]< arr[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            if (minIndex !=i){
                int temp=arr[i];
                arr[i]= arr[minIndex];
                arr[minIndex]=temp;
            }
        }
    }
}
