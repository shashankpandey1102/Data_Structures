package Tree;
import java.util.ArrayList;
import java.util.List;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int value) {
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(value < root.data){
            root.left = insert(root.left, value);
        }
        else{
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null)
        return;
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean searchBST(Node root, int key){
        if(root == null)
        return false;

        if(root.data == key){
        return true;
        }
        else if(key < root.data){
            return searchBST(root.left, key);
        }
        else{
            return searchBST(root.right, key);
        }
        
    }

    public static Node deleNode(Node root, int value) {
        if(value < root.data){
            root.left = deleNode(root.left, value);
        }
        else if(value > root.data){
            root.right = deleNode(root.right, value);
        }
        else{   //value == root.data

            //case 1 -> No Child
            if(root.left == null && root.right == null)
            return null;

            //case 2 -> Only One child
            if(root.right == null)  //Only left child
            return root.left;
            else if(root.left == null)   //Only right child
            return root.right;

            //case 3 -> Have both left and right child( therefore return inorder successor )
            Node IS = getLeftMostChild(root.right);
            root.data = IS.data;
            root.right = deleNode(root.right, IS.data);
        }

        return root;
    }
    public static Node getLeftMostChild(Node root) {
        Node curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    public static void printInRange(Node root, int X, int Y) {
        if(root == null)
        return;
        //case 1 -> X is less than equal to root and y is greater than equal to root
        if(X <= root.data && Y >= root.data){
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if(X > root.data){     // case 2 
            printInRange(root.right, X, Y);
        }
        else if(Y < root.data){     //case 3
            printInRange(root.left, X, Y);
        }
    }
    public static void printPath(ArrayList<Integer> path) {
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    public static void printPathRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null)
        return;

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
            printPathRoot2Leaf(root.left, path);
            printPathRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        //int[] values = {5, 1, 3, 4, 2, 7};
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        // boolean check = searchBST(root, 4);
        // System.out.println(check);

        // deleNode(root, 8);
        // inOrder(root);
        // System.out.println();

        // printInRange(root, 6, 10);
        // System.out.println();

        printPathRoot2Leaf(root, new ArrayList<Integer>());
    }
}
