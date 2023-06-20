package Tree;

import java.util.ArrayList;
import java.util.List;

public class practice2 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree{
        static int index = -1;

        Node buildTree(int[] nodes){
            index++;

            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if(root == null)
        return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null)
        return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null)
        return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter(Node root){
        if(root == null)
        return new TreeInfo(0, 0);

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(diam1, Math.max(diam2, diam3));

        return new TreeInfo(myHeight, myDiam);
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        //int[] nodes1= {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        //System.out.println(root.data);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();

        int diameter = diameter(root).diam;
        System.out.println(diameter);
    }
}
