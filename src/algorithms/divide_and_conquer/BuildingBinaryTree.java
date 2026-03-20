package algorithms.divide_and_conquer;

import data_structures.trees.BTTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BuildingBinaryTree {
    static int[] preorder = {3,9,20,15,7};
    static int[] inorder = {9,3,15,20,7};
    static int preIndex=0;
    static Map<Integer, Integer> inOrderMap=new HashMap<>();

    static void main(String[] args) {
        BTTreeNode node=buildTree();
        System.out.println("levelOrder traversal::::");
        levelOrderPrint(node);
        System.out.println("\npreOrder traversal::::");
        preOrderPrint(node);
        System.out.println("\ninOrder traversal::::");
        inOrderPrint(node);
        System.out.println("\npostOrder traversal::::");
        postOrderPrint(node);
    }

    public static BTTreeNode buildTree(){
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        return treeConstruction(0,inorder.length-1);
    }

    public static BTTreeNode treeConstruction(int inorderStart,int inorderEnd) {
        if(inorderStart>inorderEnd) {
            return null;
        }
        int root=preorder[preIndex++];
        int rootIndexInInorder=inOrderMap.get(root);
        BTTreeNode newTree=new BTTreeNode(root);

        newTree.left=treeConstruction(inorderStart,rootIndexInInorder-1);
        newTree.right=treeConstruction(rootIndexInInorder+1,inorderEnd);

        return newTree;
    }

    //This is BFS
    public static void levelOrderPrint(BTTreeNode tree) {
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
        if(node==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        System.out.print(node.val+" ");
        if(node.left!=null) preOrderPrint(node.left);
        if(node.right!=null) preOrderPrint(node.right);
    }
    //Following is DFS
    public static void inOrderPrint(BTTreeNode node) {
        if(node==null) {
            System.out.println("Tree is Empty!!");
            return;
        }
        if(node.left!=null) inOrderPrint(node.left);
        System.out.print(node.val+" ");
        if(node.right!=null) inOrderPrint(node.right);
    }
    //following is DFS
    public static void postOrderPrint(BTTreeNode node) {
        if(node==null) {
            System.out.println("Tree is Empty!!");
            return;
        }

        if(node.left!=null) postOrderPrint(node.left);
        if(node.right!=null) postOrderPrint(node.right);
        System.out.print(node.val+" ");
    }
}
