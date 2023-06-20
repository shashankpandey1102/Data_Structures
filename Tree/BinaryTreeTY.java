package Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTY {
    
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

    public static void preOrder(Node root){
        if(root == null)
        return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null)
        return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null)
        return;
    
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if(root == null)
        return;


        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty())
                return;
                else
                q.add(null);
            }
            else{
                System.out.print(curr.data + " ");
                if(curr.left != null)
                q.add(curr.left);

                if(curr.right != null)
                q.add(curr.right);
            }
        }
    }

    public static int countNodes(Node root){
        if(root == null)
        return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        int totalCount = leftCount + rightCount + 1;

        return totalCount;
    }

    public static int sumOfNodes(Node root){
        if(root == null)
        return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        int totalSum = leftSum + rightSum + root.data;

        return totalSum;
    }

    public static int heightOfNodes(Node root){
        if(root == null)
        return 0;

        int leftHeight = heightOfNodes(root.left);
        int rightHeight = heightOfNodes(root.right);
        int totalHeight = Math.max(leftHeight, rightHeight) + 1;

        return totalHeight;
    }

    public static int diameter(Node root){
        if(root == null)
        return 0;
        
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = heightOfNodes(root.left) + heightOfNodes(root.right) + 1;

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root == null)
        return new TreeInfo(0, 0);

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(diam1, Math.max(diam2, diam3));

        TreeInfo newInfo = new TreeInfo(myHeight, myDiam);
        
        return newInfo;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        //int[] nodes1= {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        System.out.println(root.data);

        //preOrder(root);

        //inOrder(root);

        //postOrder(root);

        // levelOrder(root);

        //levelOrder2(root);
        

        // int count = countNodes(root);
        // System.out.println(count);

        // int sum = sumOfNodes(root);
        // System.out.println(sum);

        // int height = heightOfNodes(root);
        // System.out.println(height);

        // int diameter = diameter(root);
        // System.out.println(diameter);

        // int diameter = diameter2(root).diam;
        // System.out.println(diameter);
    }
}
