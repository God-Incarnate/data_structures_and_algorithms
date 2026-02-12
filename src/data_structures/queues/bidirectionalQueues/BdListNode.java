package data_structures.queues.bidirectionalQueues;

public class BdListNode {
    int val;
    BdListNode next;
    BdListNode prev;

    public BdListNode(int x){
        this.val=x;
    }

    public BdListNode(int x ,BdListNode next,BdListNode prev){
        this.val=x;
        this.next=next;
        this.prev=prev;
    }
}
