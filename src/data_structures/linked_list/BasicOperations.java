package data_structures.linked_list;

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

    /*Steps:
            1. If one list is null, return the other list because merging with empty list gives the same list.
            2. Create a dummy node to simplify handling of the head.
            3. Use a pointer 'current' to build the merged list.
            4. Compare nodes from both lists:
                - Attach the smaller node to merged list.
                - Move pointer of that list forward.
            5. Continue until one list becomes empty.
            6. Attach remaining nodes from the non-empty list.
            7. Return mergedList.next because mergedList is a dummy node.

    Time Complexity: O(n + m)
    Space Complexity: O(1)
*/
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
        if (a!=null) {
                current.next=a;
        }
        if (b!=null) {
                current.next=b;
        }
        return mergedList.next;
    }

}
