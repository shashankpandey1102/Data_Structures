package Tree;

import java.util.ArrayList;
import java.util.List;

public class kNodesFar {
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

    public static List<Node> nodeToRoot(Node root, int data){
        if(root == null){
            return new ArrayList<>();
        }

        if(root.data == data){
            List<Node> newList = new ArrayList<>();
            newList.add(root);
            return newList;
        }

        List<Node> lList = nodeToRoot(root.left, data);
        if(lList.size() > 0){
            lList.add(root);
            return lList;
        }

        List<Node> rList = nodeToRoot(root.right, data);
        if(rList.size() > 0){
            rList.add(root);
            return rList;
        }

        return new ArrayList<>();
    }

    public static List<Node> nodeToRoot2(Node root, int data) {
        List<Node> list = new ArrayList<>();

        if(hasPath(root, data, list))
        return list;

        return new ArrayList<>();
    }

    public static boolean hasPath(Node root, int data, List<Node> list) {
        if(root == null)
        return false;

        list.add(root);

        if(root.data == data)
        return true;

        if(hasPath(root.left, data, list) || hasPath(root.right, data, list))
        return true;

        list.remove(list.size() - 1);

        return false;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, 8, -1, -1, 9, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);
        inOrder(root);
        System.out.println();

        List<Node> list = nodeToRoot2(root, 8);
        System.out.println(list);
    }
}
