package Tree;

import java.util.*;

public class lOrder {

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
        static int idx = -1;
        Node buildTree(int[] nodes){
            idx++;
            
            if(nodes[idx]==-1)
            return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
    }

    public static void levelOrder(Node root) {
        if(root == null)
        return;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int count = q.size();
            ArrayList<Integer> arr = new ArrayList<>(count);
            
            for(int i = 0; i < count; i++){
                Node curr = q.poll();
                arr.add(curr.data);

                if(curr.left != null)
                q.add(curr.left);

                if(curr.right != null)
                q.add(curr.right);
            }

            result.add(arr);
        }

        System.out.println(result);

    }

    public static List<Integer> rightSideView(Node root) {
        if(root == null)
        return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, result);

        return result;
    }

    public static void rightSideViewHelper(Node root, List<Integer> list){
        Node curr = root;
        
        while(curr != null){
            list.add(curr.data);
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] nodes2 = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
        int[] nodes3 = {1, -1, 2, -1, -1};
        int[] nodes4 = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, 8, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes4);
        
        //System.out.println(root.data);
        levelOrder(root);
        System.out.println();

        List<Integer> result = rightSideView(root);
        System.out.println(result);
        
    }
}
