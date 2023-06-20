package Tree;

import java.util.ArrayList;

public class practice {
    
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

    public static void inOrder(Node root) {
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void printAllPathRootToLeaf(Node root, ArrayList<Integer> list) {
        if(root == null){
            return;
        }

        list.add(root.data);

        if(root.left == null && root.right == null){
            System.out.println(list);
        }

        printAllPathRootToLeaf(root.left, list);
        printAllPathRootToLeaf(root.right, list);

        list.remove(list.size()-1);
    }

    public static void printPath(ArrayList<Integer> list) {
        for(int i = list.size()-1; i >= 0; i--){
            System.out.print(list.get(i) + "->");
        }
        System.out.println();
    }

    public static void printAllPathLeafToRoot(Node root, ArrayList<Integer> list) {
        if(root == null){
            return;
        }

        list.add(root.data);

        if(root.left == null && root.right == null){
            printPath(list);
        }

        printAllPathLeafToRoot(root.left, list);
        printAllPathLeafToRoot(root.right, list);

        list.remove(list.size()-1);
    }

    public static void printPathWithTarget(Node root, int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(hasPath(root, x, list)){
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        else{
            System.out.println("No Path");
        }
    }

    public static boolean hasPath(Node root, int x, ArrayList<Integer> list) {
        if(root == null)
        return false;

        list.add(root.data);

        if(root.data == x){
            return true;
        }
        

        boolean left = hasPath(root.left, x, list);
        boolean right = hasPath(root.right, x, list);

        if(left || right){          //Programatically if left comes true it does not evaluate right
            return true;
        }

        list.remove(list.size()-1);
        
        return false;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);
        inOrder(root);
        System.out.println();

        printAllPathRootToLeaf(root, new ArrayList<>());
        //printAllPathLeafToRoot(root, new ArrayList<>());

        printPathWithTarget(root, 5);
    }
}
