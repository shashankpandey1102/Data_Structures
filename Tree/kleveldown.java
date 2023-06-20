package Tree;

import java.util.ArrayList;

public class kleveldown {
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

    public static ArrayList<Node> nodeToRoot(Node node, int data) {
        if(node == null)
        return new ArrayList<>();

        if(node.data == data){
            ArrayList<Node> list = new ArrayList<Node>();
            list.add(node);
            return list;
        }

        ArrayList<Node> lList = nodeToRoot(node.left, data);
        if(lList.size() > 0){
            lList.add(node);
            return lList;
        }

        ArrayList<Node> rList = nodeToRoot(node.right, data);
        if(rList.size() > 0){
            rList.add(node);
            return rList;
        }
        
        return new ArrayList<>();
    }

    public static void printKLevelDown(Node root, int k, Node blocker) {
        if(root == null || k < 0 || root == blocker)
        return;

        if(k == 0){
            System.out.print(root.data + " ");
        }

        printKLevelDown(root.left, k-1, blocker);
        printKLevelDown(root.right, k-1, blocker);
    }

    public static void printKNodesFar(Node root, int data, int k) {
        ArrayList<Node> path = nodeToRoot(root, data);
        for(int i = 0; i < path.size(); i++){
            printKLevelDown(path.get(i), k - i, i == 0 ? null : path.get(i-1));
        } 
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, 8, -1, -1, 9, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);
        inOrder(root);
        System.out.println();

        printKNodesFar(root, 3, 2);


    }
}
