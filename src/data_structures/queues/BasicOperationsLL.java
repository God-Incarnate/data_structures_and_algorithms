package data_structures.queues;

import data_structures.linked_list.ListNode;

public class BasicOperationsLL {
    static ListNode front, rear;

    static void main(String[] args) {
        System.out.println("Adding Value to queue: ");
        push(4);
        push(6);
        System.out.println("Current queue:::::::");
        printQueue();
        dequeue();

        System.out.println("Current queue:::::::");
        printQueue();
    }

    public static void push(int value) {
        if (front==null){
            front=new ListNode(value);
            rear=front;
            return;
        }
        rear.next=new ListNode(value);
        rear=rear.next;
    }

    public static void printQueue() {
        ListNode current=front;
        System.out.print("[ ");
        while (current!=null){
            System.out.print(current.val+" ");
            current=current.next;
        }
        System.out.print("]");
    }

    public static void dequeue(){
        if (front==null){
            System.out.println("\nNo Element in queue to delete");
            return;
        }
        if(front == rear){
            System.out.println("\nRemoved value: "+ front.val);
            front=front.next;
            rear=rear.next;
            return;
        }
        System.out.println("\nRemoved value: "+ front.val);
        front=front.next;
    }

}
