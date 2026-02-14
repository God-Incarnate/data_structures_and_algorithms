package data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperationsBinaryTree {
    static BTTreeNode tree;
    static void main(String[] args) {

        treeCreator();
        System.out.println("Tree CREATED-----");
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
        tree=new BTTreeNode(1);
        BTTreeNode c1=new BTTreeNode(2);
        BTTreeNode c2=new BTTreeNode(3);
        BTTreeNode c3=new BTTreeNode(4);
        BTTreeNode c4=new BTTreeNode(5);
        BTTreeNode c5=new BTTreeNode(6);
        BTTreeNode c6=new BTTreeNode(7);

        tree.left=c1;
        tree.right=c2;
        c1.left=c3;
        c1.right=c4;
        c3.left=c5;
        c3.right=c6;
        /* Tree created is as follows:
                1
               / \
              2   3
             / \
            4   5
           / \
          6   7                    */
    }
    //This is BFS
    public static void levelOrderPrint() {
        if (tree==null) {
            System.out.println("Tree is EMPTY!!");
            return;
        }
        Queue<BTTreeNode> queue=new LinkedList<>();

        queue.add(tree);
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
    //Following is DFS
    public static void preOrderPrint(BTTreeNode node) {
        if(tree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        System.out.print(node.val+" ");
        if(node.left!=null) preOrderPrint(node.left);
        if(node.right!=null) preOrderPrint(node.right);
    }
    //Following is DFS
    public static void inOrderPrint(BTTreeNode node) {
        if(tree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        if(node.left!=null) inOrderPrint(node.left);
        System.out.print(node.val+" ");
        if(node.right!=null) inOrderPrint(node.right);
    }
    //following is DFS
    public static void postOrderPrint(BTTreeNode node) {
        if(tree==null) {
            System.out.println("Tree is Empty!!");
            return;
        }

        if(node.left!=null) postOrderPrint(node.left);
        if(node.right!=null) postOrderPrint(node.right);
        System.out.print(node.val+" ");
    }
}
