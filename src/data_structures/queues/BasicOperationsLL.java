package data_structures.queues;

import data_structures.linked_list.ListNode;

public class BasicOperationsLL {
    static ListNode front, rear;

    public static void main(String[] args) {
        System.out.println("Adding Value to queue: ");
        push(4);
        push(6);
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
        while (current!=null){
            System.out.print(current.val+" ");
            current=current.next;
        }
    }


}
