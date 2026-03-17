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

    public static void merge(int left, int mid, int right) {
        int n1=mid-left+1;
        int n2=right-mid;
        int[] ar1=new int[n1];
        int[] ar2=new int[n2];

        for (int i=0;i<n1;i++) {
            ar1[i]=arr[left+i];
        }

        for (int j=0;j<n2;j++) {
            ar2[j]=arr[mid+j+1];
        }

        int i=0,j=0;
        int k=left;
        while (i<n1 && j<n2){
            if (ar1[i]<=ar2[j]) {
                arr[k]=ar1[i];
                i++;
            }else {
                arr[k]=ar2[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k]=ar1[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k]=ar2[j];
            j++;
            k++;
        }

    }
}
