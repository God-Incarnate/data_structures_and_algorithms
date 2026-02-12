package data_structures.queues.bidirectionalQueues;

public class BasicOperationsLinkedList {
    static BdListNode front, rear;

    static void main(String[] args) {
        enqueueFirst(5);
        enqueueFirst(3);
        enqueueLast(1);
        enqueueLast(4);
        dequeueFirst();
        dequeueLast();
        dequeueLast();
    }

    public static void enqueueFirst(int x) {
        BdListNode newNode=new BdListNode(x);
        System.out.println("\nAdded element to first: "+x);
        BdListNode oldNode=front;
        if (front==null) {
            front=rear=newNode;
            printQueue();
            return;
        }
        newNode.next=oldNode;
        oldNode.prev=newNode;
        front=newNode;
        printQueue();
    }

    public static void enqueueLast(int x) {
        BdListNode newNode=new BdListNode(x);
        System.out.println("\nAdded element to last: "+x);
        if(front==null){
            front=rear=newNode;
            printQueue();
            return;
        }
        rear.next=newNode;
        newNode.prev=rear;
        rear=rear.next;
        printQueue();

    }

    public static void dequeueFirst() {
        if(front==null) {
            System.out.println("\nThe Queue is EMPTY");
            return;
        }
        System.out.println("\nRemoved element from first: "+front.val);
        front=front.next;
        front.prev=null;
        printQueue();
    }

    public static void dequeueLast() {
        if(rear==null){
            System.out.println("\nThe QUEUE is EMPTY");
            return;
        }
        System.out.println("\nRemoved Element from last: "+rear.val);
        rear=rear.prev;
        rear.next=null;
        printQueue();
    }

    public static void printQueue() {
        BdListNode current=front;
        System.out.print("[ ");
        while (current!=null) {
            System.out.print(current.val+" ");
            current=current.next;
        }
        System.out.print("]");
    }

}
