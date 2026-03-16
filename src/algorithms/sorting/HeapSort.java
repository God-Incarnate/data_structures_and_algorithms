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

    public static void heapify(int n,int i){
        int largest=i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<n && arr[left]>arr[largest]){
            largest=left;
        }
        if (right<n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(n,largest);
        }
    }
}
