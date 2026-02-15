package data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperationsBST {
    static BTTreeNode bstTree;

    static void main(String[] args) {
        insert(8);
        insert(4);
        insert(10);
        insert(3);
        insert(6);
        insert(9);
        insert(12);
        insert(5);
        insert(7);
        insert(11);
        System.out.println("Leve order traversal:::::");
        levelOrderPrint();
        System.out.println("\nInOrder traversal:::::");
        inOrderPrint(bstTree);
    }

    public static void insert(int x) {
        if (bstTree==null) {
            bstTree=new BTTreeNode(x);
            return;
        }
        BTTreeNode current = bstTree;
        BTTreeNode prev = bstTree;
        while(current!=null){
            if(current.val>x){
                prev=current;
                current=current.left;
            } else if(current.val<x) {
                prev=current;
                current=current.right;
            } else {
                System.out.println("ERROR - Duplicate Entries Not Allowed!!!!.");
                return;
            }
        }
        current=new BTTreeNode(x);
        if(prev.val>x){
            prev.left=current;
        } else {
            prev.right=current;
        }
    }

    public static void inOrderPrint(BTTreeNode node) {
        if(bstTree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        if(node.left!=null) inOrderPrint(node.left);
        System.out.print(node.val+" ");
        if(node.right!=null) inOrderPrint(node.right);
    }

    public static void levelOrderPrint() {
        if (bstTree==null) {
            System.out.println("Tree is EMPTY!!");
            return;
        }
        Queue<BTTreeNode> queue=new LinkedList<>();

        queue.add(bstTree);
        while (!queue.isEmpty()) {
            BTTreeNode current=queue.poll();
            System.out.print(current.val+" ");
            if (current.left!=null) {
                queue.add(current.left);
            }
            if (current.right!=null) {
                queue.add(current.right);
            }
        }
    }
}
