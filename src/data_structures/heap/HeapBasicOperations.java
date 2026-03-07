package data_structures.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapBasicOperations {
    /*
    Creating minheap/maxHeap from an array:::::
| Method               | Time to Build      | When to Use      |
| -------------------- | ------------------ | ---------------- |
| PriorityQueue insert | O(n log n)         | Easy coding      |
| Heapify array        | **O(n)**           | Best performance |
| Streaming insert     | O(n log n)         | Real-time data   |
| Custom class         | O(n) or O(n log n) | Interviews       |
| Comparator heap      | O(n log n)         | Objects          |
| Streams              | O(n log n)         | Functional style |
    */

    static PriorityQueue<Integer> minHeapPQ= new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeapPQ = new PriorityQueue<>(Collections.reverseOrder());

    static void main(String[] args) {
        int[] arr= {1,3,6,4,5,9,2};
        minHeapCreator(arr);
        maxHeapCreator(arr);

        System.out.println("-------USING HEAPIFY-------");
        for (int i = (arr.length/2)-1;i>=0;i--) {
            minHeapCreatorHeapify(arr,i,arr.length);
        }
        printHeap(arr,"Min Heap");

        for (int i = (arr.length/2)-1;i>=0;i--) {
            maxHeapCreatorHeapify(arr,i,arr.length);
        }
        printHeap(arr,"Max Heap");

    }

    public static void minHeapCreator(int[] arr) {
        if(arr.length==0){
            return;
        }
        System.out.println("-------USING PRIORITYQUEUE-------");
        for(int i = 0 ; i<=arr.length-1; i++) {
            minHeapPQ.offer(arr[i]);
        }
        System.out.println("min Heap created using Priority Queue.\nminHeap:::::");
        System.out.println("Heap Elements::::");
        for (int nums:minHeapPQ){
            System.out.print(nums+" ");
        }
        System.out.println("\nHeap Elements in sorted order:::::");
        while (!minHeapPQ.isEmpty()) {
            System.out.print(minHeapPQ.poll()+" ");
        }
        System.out.println();

    }

    public static void minHeapCreatorHeapify(int[] arr, int i, int n) {
        if (arr.length==0) {
            return;
        }
        int smallest = i;
        int left = (2*i)+1;
        int right = (2*i)+2;

        if (left < n && arr[left]<arr[smallest]) {
            smallest=left;
        }
        if (right < n && arr[right]<arr[smallest]) {
            smallest=right;
        }
        if (smallest !=i) {
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;

            minHeapCreatorHeapify(arr, smallest, arr.length);
        }

    }

    public static void maxHeapCreator(int[] arr) {
        if (arr.length==0) {
            return;
        }
        System.out.println("-------USING PRIORITY QUEUE-------");
        for (int num: arr) {
            maxHeapPQ.offer(num);
        }
        System.out.println("max Heap created using Priority Queue.\nmaxHeap:::::");
        System.out.println("Heap Elements::::");
        for (int nums: maxHeapPQ) {
            System.out.print(nums+" ");
        }
        System.out.println("\nHeap Elements in sorted order:::::");
        while (!maxHeapPQ.isEmpty()) {
            System.out.print(maxHeapPQ.poll()+" ");
        }
        System.out.println();

    }

    public static void maxHeapCreatorHeapify(int[] arr, int i , int n) {
        if (arr.length==0) {
            return;
        }
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]>arr[largest]) {
            largest=left;
        }
        if (right <n && arr[right]>arr[largest]) {
            largest=right;
        }
        if (largest!=i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest]=temp;

            maxHeapCreatorHeapify(arr,largest,n);
        }
    }

    public static void printHeap(int[] arr, String type) {
        System.out.println("Printing "+type);
        for (int nums:arr) {
            System.out.print(nums+" ");
        }
        System.out.println();
    }
}
