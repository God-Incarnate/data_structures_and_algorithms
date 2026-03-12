package algorithms.searching;

import data_structures.trees.BTTreeNode;

public class BSTSearch {

    static void main(String[] args) {

    /*
            50
           /  \
         30    70
        / \    / \
       20 40  60 80
    */

        BTTreeNode root = new BTTreeNode(50);
        root.left = new BTTreeNode(30);
        root.right = new BTTreeNode(70);
        root.left.left = new BTTreeNode(20);
        root.left.right = new BTTreeNode(40);
        root.right.left = new BTTreeNode(60);
        root.right.right = new BTTreeNode(80);

        BTTreeNode result = searchIterative(root, 40);

        if (result != null)
            System.out.println("Found: " + result.val);
        else
            System.out.println("Not Found");
    }

    /*
     * Search a value in BST using recursion
     *
     * Time Complexity:
     *  - Best / Avg  : O(log n)   -> balanced BST
     *  - Worst       : O(n)       -> skewed tree
     *
     * Space Complexity:
     *  - O(h) recursion stack
     *  - h = height of tree
     */
    public static BTTreeNode searchRecursive(BTTreeNode root, int key) {

        // Base Case 1: Tree empty
        if (root == null)
            return null;

        // Base Case 2: Found element
        if (root.val == key)
            return root;

        // If key smaller -> search left subtree
        if (key < root.val)
            return searchRecursive(root.left, key);

        // Else search right subtree
        return searchRecursive(root.right, key);
    }

    //Using iteration:::::
    public static BTTreeNode searchIterative(BTTreeNode root, int key) {

        /*
         * Time Complexity:
         *   Best / Avg : O(log n)
         *   Worst      : O(n)
         *
         * Space Complexity:
         *   O(1)  (no recursion stack)
         */

        while (root != null) {

            if (root.val == key)
                return root;

            else if (key < root.val)
                root = root.left;

            else
                root = root.right;
        }

        return null; // Not found
    }
}
