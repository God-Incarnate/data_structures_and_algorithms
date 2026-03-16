package algorithms.sorting;

import java.util.Arrays;

public class CountingSort {
    static int[] arr={2,4,6,3,2,1,7,5,9};

    static void main(String[] args) {

        countingSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(){
        int n=arr.length-1;
        int max=0;
        for (int i=0;i<=n;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }

        int[] count=new int[max+1];
        for(int num:arr){
            count[num]++;
        }

        for (int i=1;i<count.length;i++){
            count[i]=count[i]+count[i-1];
        }
        int[] output=new int[n+1];
        for(int i=n;i>=0;i--){
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }

        for (int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }
}
