package data_structures.queues;

import java.util.Arrays;

public class BasicOperationsArrays {
    static int[] queue;
    static int front;
    static int queueSize;

    public static void main(String[] args) {
        arrayQueue(10);
        System.out.println("Adding Value to queue : ");
        enqueue(3);
        printQueue();
        System.out.println("\nAdding Value to queue : ");
        enqueue(8);
        printQueue();
        System.out.println("\nAdding Value to queue : ");
        enqueue(5);
        printQueue();
        System.out.println("\nAdding Value to queue : ");
        enqueue(1);
        printQueue();
        System.out.println("\nRemoving element from queue : ");
        dequeue();
        printQueue();

    }

    public static void arrayQueue(int capacity){
        queue= new int[capacity];
        front=0;
        queueSize=0;
    }

    public static int rear(){
        return (front+queueSize)%queue.length;
    }

    public static void enqueue(int value){
        if (queueSize==queue.length){
            System.out.println("ArrayQueue os maxed out!!!");
            return;
        }
        queue[rear()]=value;
        queueSize++;
    }

    public static void printQueue() {
        for (int i=0, j=front;i<queueSize;i++,j++) {
            System.out.print(queue[j%queue.length]+" ");
        }
    }

    public static void dequeue(){
        if (queueSize==0){
            System.out.println("No element in queue to remove");
            return;
        }
        front= (front+1)%queue.length;
        queueSize--;
    }
}
