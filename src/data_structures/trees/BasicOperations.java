package data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperations {
    static TreeNode tree;
    static void main(String[] args) {

        treeCreator();
        System.out.println("level Order traversal: ");
        levelOrderPrint();
        System.out.println("\npre Order traversal: ");
        preOrderPrint(tree);
        System.out.println("\nin Order traversal: ");
        inOrderPrint(tree);
        System.out.println("\npost Order traversal: ");
        postOrderPrint(tree);
    }

    public static void treeCreator(){
        tree=new TreeNode(1);
        TreeNode c1=new TreeNode(2);
        TreeNode c2=new TreeNode(3);
        TreeNode c3=new TreeNode(4);
        TreeNode c4=new TreeNode(5);
        TreeNode c5=new TreeNode(6);
        TreeNode c6=new TreeNode(7);

        tree.left=c1;
        tree.right=c2;
        c1.left=c3;
        c1.right=c4;
        c3.left=c5;
        c3.right=c6;
    }
    //This is BFS
    public static void levelOrderPrint() {
        if (tree==null) {
            System.out.println("Tree is EMPTY!!");
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(tree);
        while (!queue.isEmpty()) {
         TreeNode current=queue.poll();
         System.out.print(current.val+" ");
         if (current.left!=null) {
             queue.add(current.left);
         }
         if (current.right!=null) {
             queue.add(current.right);
         }
        }
    }
    //Following is DFS
    public static void preOrderPrint(TreeNode node) {
        if(tree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        System.out.print(node.val+" ");
        if(node.left!=null) preOrderPrint(node.left);
        if(node.right!=null) preOrderPrint(node.right);
    }
    //Following is DFS
    public static void inOrderPrint(TreeNode node) {
        if(tree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        if(node.left!=null) inOrderPrint(node.left);
        System.out.print(node.val+" ");
        if(node.right!=null) inOrderPrint(node.right);
    }
    //following is DFS
    public static void postOrderPrint(TreeNode node) {
        if(tree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }

        if(node.left!=null) postOrderPrint(node.left);
        if(node.right!=null) postOrderPrint(node.right);
        System.out.print(node.val+" ");
    }
}
