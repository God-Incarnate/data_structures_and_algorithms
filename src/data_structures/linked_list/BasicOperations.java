package data_structures.linked_list;

import java.util.Map;

import static java.util.Objects.isNull;

public class BasicOperations {
    static void main(String[] args) {
        ListNode node1 = insertElement(listCreator1(),2,7);
        ListNode node2 = insertElement(listCreator2(),1,1);
        System.out.println("inserted an element:");
        printList(node1);
        System.out.println("\ndeleted an element:");
        printList(deleteElement(node1,2));
        System.out.println("\nsearched an element:");
        System.out.println(searchElement(node1,2).val);
        System.out.println("\n------------reversing the list:----------");
        System.out.println("Existing Node2: ");
        printList(node2);
        System.out.println("\nreversed list: ");
        printList(reverseList(node2));
        System.out.println("\n-------------------------------------------");
        System.out.println("--------------merged sorted list-------------");
        System.out.println("\nExisting list1 :");
        ListNode empty = null;
        printList(node1);
        System.out.println("\nExisting List2:");
        node2=listCreator2();
        printList(node2);
        System.out.println("\nAfter merging both: ");
        printList(mergeSortedLists(node1,node2));
        System.out.println("\n-------------------------------------------");
    }

    public static ListNode listCreator1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        return head;
    }

    public static ListNode listCreator2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static ListNode insertElement(ListNode head, int insertAfter, int insertValue) {
        ListNode newNode = new ListNode(insertValue);
        ListNode current = head;
        while (current.val != insertAfter) {
            current=current.next;
        }
        newNode.next=current.next;
        current.next=newNode;
        return head;
    }

    public static ListNode deleteElement(ListNode head, int deleteValue) {
        if (head.val== deleteValue) {
            return head.next;
        }
        ListNode current = head;
        while (current.val!= deleteValue) {
            current=current.next;
        }
        current.next=current.next.next;
        return head;
    }

    public static ListNode searchElement(ListNode head, int searchValue) {
        ListNode current = head;
        while (current != null) {
            if (current.val == searchValue) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode lastNode = null;
        while (current!=null){
            ListNode nextNode = current.next;
            current.next=lastNode;
            lastNode=current;
            current= nextNode;
        }
        return lastNode;
    }

    public static ListNode mergeSortedLists(ListNode a,ListNode b){
        if (isNull(a)) return b;
        if (isNull(b)) return a;
        ListNode mergedList= new ListNode(0);
        ListNode current=mergedList;
        while (a!=null && b!=null) {
            if (a.val<=b.val) {
                current.next=a;
                a=a.next;
            } else {
                current.next=b;
                b=b.next;
            }
            current=current.next;
        }
        if (a!=null && isNull(b)) {
                current.next=a;
        } else if (b!=null && isNull(a)) {
                current.next=b;
        }
        return mergedList.next;
    }

}
