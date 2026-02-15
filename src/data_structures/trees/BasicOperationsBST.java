package data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperationsBST {
    /**
     * Root node of the Binary Search Tree.
     * All insertions and traversals start from this node.
     */
    static BTTreeNode bstTree;

    static void main(String[] args) {
        // Insert values into BST
        // Order matters in BST structure
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

    /**
     * Inserts a value into the Binary Search Tree.
     *
     * BST Property:
     * left subtree  -> values smaller than node
     * right subtree -> values greater than node
     *
     * Duplicate values are not allowed.
     *
     * Time Complexity:
     * O(h) where h = height of tree
     * Worst case = O(n) if tree becomes skewed
     */
    public static void insert(int x) {
        // If tree is empty → new node becomes root
        if (bstTree==null) {
            bstTree=new BTTreeNode(x);
            return;
        }
        // current → node we are checking
        // prev → parent of current
        BTTreeNode current = bstTree;
        BTTreeNode prev = bstTree;

        // Traverse tree until we reach end of respective position
        while(current!=null){
            if(current.val>x){
                // Move left because x is smaller
                prev=current;
                current=current.left;
            } else if(current.val<x) {
                // Move right because x is bigger
                prev=current;
                current=current.right;
            } else {
                // Duplicate found → not allowed
                System.out.println("ERROR - Duplicate Entries Not Allowed!!!!.");
                return;
            }
        }
        // Create new node after finding correct position
        current=new BTTreeNode(x);

        // Attach node to parent
        if(prev.val>x){
            prev.left=current;
        } else {
            prev.right=current;
        }
    }

    /**
     * Prints BST in InOrder traversal.
     *
     * Order:
     * Left → Root → Right
     *
     * Property:
     * In BST, this prints values in sorted order.
     */
    public static void inOrderPrint(BTTreeNode node) {
        // If tree empty
        if(bstTree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        // Visit left subtree
        if(node.left!=null) inOrderPrint(node.left);
        // Print current node
        System.out.print(node.val+" ");
        // Visit right subtree
        if(node.right!=null) inOrderPrint(node.right);
    }

    /**
     * Prints BST in Level Order (Breadth First Search).
     *
     * Uses Queue:
     * Visit nodes level by level.
     *
     * Example:
     *        8
     *      /   \
     *     4     10
     * Output → 8 4 10 3 6 9 12 ...
     */
    public static void levelOrderPrint() {
        // If tree empty
        if (bstTree==null) {
            System.out.println("Tree is EMPTY!!");
            return;
        }
        // Queue used for BFS traversal
        Queue<BTTreeNode> queue=new LinkedList<>();

        // Start with root
        queue.add(bstTree);
        while (!queue.isEmpty()) {
            // Remove front node
            BTTreeNode current=queue.poll();
            // Print node value
            System.out.print(current.val+" ");

            // Add children to queue
            if (current.left!=null) {
                queue.add(current.left);
            }
            if (current.right!=null) {
                queue.add(current.right);
            }
        }
    }
}
