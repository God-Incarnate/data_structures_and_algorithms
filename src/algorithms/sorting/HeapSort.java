package algorithms.sorting;

import java.util.Arrays;

public class HeapSort {
    static int[] arr={2,4,6,3,2,1,7,5,9};

    static void main(String[] args){
        heapSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(){
        int n=arr.length;
        for (int i=n/2-1;i>=0;i--){
            heapify(n,i);
        }

        for (int i=n-1;i>0;i--) {

            int swapRoot=arr[i];
            arr[i]=arr[0];
            arr[0]=swapRoot;

            heapify(i,0);
        }
    }
    
}
