package Graph;


import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class Graph1 {

    public static void adjMatrix(int m, int n){

        int [][] adj = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            System.out.println("Enter connection " + (i+1) + ": ");
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter u : ");
            int u = sc.nextInt();

            System.out.println("Enter v : ");
            int v = sc.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        for(int[] row : adj){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void BFS(int start, int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();

            System.out.print(node + " ");
            for(int a : adj.get(node)){
                if(!visited[a]){
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    public static void DFS(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        
        visited[s] = true;

        System.out.print(s + " ");
        Iterator<Integer> itr = adj.get(s).listIterator();

        while(itr.hasNext()){
            int n = itr.next();

            if(!visited[n]){
                DFS(n, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        //adjMatrix(7, 4);

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
        int start = 0;

        BFS(start, V, adj);
        System.out.println();
        DFS(start, new boolean[V], adj);

    }
   
}
