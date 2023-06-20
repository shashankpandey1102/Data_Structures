package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class topological {

    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    topological(int v){
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);

        for(int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
        
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i])
            topologicalSortHelper(i, visited, stack);
        }

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }

    void topologicalSortHelper(int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;

        for(int i = 0; i < adj.get(v).size(); i++){
            int n = adj.get(v).get(i);
            if(!visited[n])
            topologicalSortHelper(n, visited, stack);
        }

        stack.push(v);
    }
    public static void main(String[] args) {
        
        topological g = new topological(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological "
                           + "sort of the given graph");
        // Function Call
        g.topologicalSort();
        System.out.println();
    }
}
