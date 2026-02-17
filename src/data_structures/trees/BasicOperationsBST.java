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
        remove(4);
        System.out.println("\nLeve order traversal:::::");
        levelOrderPrint();
        System.out.println("\nInOrder traversal:::::");
        inOrderPrint(bstTree);
    }

    /**
     * Inserts a value into the Binary Search Tree.
     * <p>
     * BST Property:
     * left subtree  -> values smaller than node
     * right subtree -> values greater than node
     * <p>
     * Duplicate values are not allowed.
     * <p>
     * Time Complexity:
     * O(h) where h = height of tree
     * Worst case = O(n) if tree becomes skewed
     */
    public static void insert(int x) {
        // If tree is empty → new node becomes root
        if (bstTree == null) {
            bstTree = new BTTreeNode(x);
            return;
        }
        // current → node we are checking
        // prev → parent of current
        BTTreeNode current = bstTree;
        BTTreeNode prev = bstTree;

        // Traverse tree until we reach end of respective position
        while (current != null) {
            if (current.val > x) {
                // Move left because x is smaller
                prev = current;
                current = current.left;
            } else if (current.val < x) {
                // Move right because x is bigger
                prev = current;
                current = current.right;
            } else {
                // Duplicate found → not allowed
                System.out.println("ERROR - Duplicate Entries Not Allowed!!!!.");
                return;
            }
        }
        // Create new node after finding correct position
        current = new BTTreeNode(x);

        // Attach node to parent
        if (prev.val > x) {
            prev.left = current;
        } else {
            prev.right = current;
        }
    }

    /** Optimized insert() below:::::::**/

//    public static void insert(int x) {
//        if (bstTree == null) {
//            bstTree = new BTTreeNode(x);
//            return;
//        }
//
//        BTTreeNode current = bstTree;
//
//        while (true) {
//            if (x < current.val) {
//                if (current.left == null) {
//                    current.left = new BTTreeNode(x);
//                    return;
//                }
//                current = current.left;
//            }
//            else if (x > current.val) {
//                if (current.right == null) {
//                    current.right = new BTTreeNode(x);
//                    return;
//                }
//                current = current.right;
//            }
//            else {
//                System.out.println("ERROR - Duplicate Entries Not Allowed!");
//                return;
//            }
//        }
//    }

    /**
     * Prints BST in InOrder traversal.
     * <p>
     * Order:
     * Left → Root → Right
     * <p>
     * Property:
     * In BST, this prints values in sorted order.
     */
    public static void inOrderPrint(BTTreeNode node) {
        // If tree empty
        if (bstTree == null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        // Visit left subtree
        if (node.left != null) inOrderPrint(node.left);
        // Print current node
        System.out.print(node.val + " ");
        // Visit right subtree
        if (node.right != null) inOrderPrint(node.right);
    }

    /**
     * Prints BST in Level Order (Breadth First Search).
     * <p>
     * Uses Queue:
     * Visit nodes level by level.
     * <p>
     * Example:
     * 8
     * /   \
     * 4     10
     * Output → 8 4 10 3 6 9 12 ...
     */
    public static void levelOrderPrint() {
        // If tree empty
        if (bstTree == null) {
            System.out.println("Tree is EMPTY!!");
            return;
        }
        // Queue used for BFS traversal
        Queue<BTTreeNode> queue = new LinkedList<>();

        // Start with root
        queue.add(bstTree);
        while (!queue.isEmpty()) {
            // Remove front node
            BTTreeNode current = queue.poll();
            // Print node value
            System.out.print(current.val + " ");

            // Add children to queue
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Removes a node with value x from the Binary Search Tree
    public static void remove(int x) {

        // If tree is empty, nothing to delete
        if (bstTree == null) {
            System.out.println("Tree is Empty!!");
            return;
        }

        // Start traversal from root
        BTTreeNode current = bstTree;
        BTTreeNode prev = bstTree;

        // Infinite loop until value is found or confirmed absent
        while (current != null) {

            // If x is smaller, go to left subtree
            if (x < current.val) {
                prev = current;
                current = current.left;
            }
            // If x is greater or equal, go to right subtree
            else if (x > current.val) {
                prev = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) {
            System.out.println("No such ELEMENT found.");
            return;
        }
        if (current.left == null || current.right == null) {
            BTTreeNode subtree = (current.left != null) ? current.left : current.right;
            if (current!=bstTree){
                if (prev.left == current) {
                    prev.left = subtree;
                } else {
                    prev.right = subtree;
                }
            } else {
                bstTree=subtree;
            }
        } else {
            BTTreeNode swapNode=current.right;
            while (swapNode.left!=null) {
                swapNode=swapNode.left;
            }
            remove(swapNode.val);
            current.val=swapNode.val;
        }
    }

}
