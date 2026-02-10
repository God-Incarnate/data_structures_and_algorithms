package data_structures.stacks;

import data_structures.linked_list.ListNode;

import static java.util.Objects.nonNull;

public class BasicOperationsLL {
    static ListNode stackTop;
    static int stackSize;

    public static void main(String[] args) {
        push(5);
        push(3);
        System.out.println("Existing Stack: ");
        printStack(stackTop);
        System.out.println("\n-----Pop data-------");
        pop();
        System.out.println("\n----Existing stack after pop---");
        printStack(stackTop);
        push(2);
        push(1);
        peek();
        System.out.println("\nSize of Existing Stack: "+stackSize);
    }

    public static void push(int value){
        ListNode node = new ListNode(value);
        node.next=stackTop;
        stackTop=node;
        stackSize++;
    }

    public static void pop(){
        if (isEmpty()){
            return;
        }
        System.out.println("Popped: ["+stackTop.val+"]");
        stackTop=stackTop.next;
        stackSize--;
    }

    public static void peek() {
        if (isEmpty()){
            return;
        }
        System.out.println("Peeked data at top: ["+stackTop.val+"]");
    }

    public static boolean isEmpty() {
        return !nonNull(stackTop);
    }

    public static void printStack(ListNode stack) {
        ListNode current=stack;
        while (current!=null){
            System.out.println("["+current.val+"]");
            current=current.next;
        }
    }
}
