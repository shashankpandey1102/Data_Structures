package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class prac {
    public static void adjMatrix(int n, int m) {
        int[][] adj = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter connection : " + (i+1) + " : ");

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

    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(List<List<Integer>> adj){
        for(int i = 0; i < adj.size(); i++){
            System.out.print(i);
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void BFS(int start, int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            int s = q.poll();

            for(int a : adj.get(s)){
                if(!visited[a]){
                    visited[a] = true;
                    q.add(a);
                }
            }
        }
    }

    public static void DFS(int start, boolean[] visited, List<List<Integer>> adj) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int a : adj.get(start)){
            if(!visited[a]){
                DFS(a, visited, adj);
            }
        }

        // for(int i = 0; i< adj.get(start).size(); i++){
        //     int n = adj.get(start).get(i);
            
        //     if(!visited[n]){
        //         DFS(n, visited, adj);
        //     }
        // }
    }
    public static void main(String[] args) {

        //adjMatrix(4, 7);

        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        // addEdge(adj, 0, 1);
        // addEdge(adj, 0, 4);
        // addEdge(adj, 1, 4);
        // addEdge(adj, 1, 3);
        // addEdge(adj, 3, 4);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 2, 3);

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);

        printGraph(adj);

        BFS(0, V, adj);
        System.out.println();
        DFS(0, new boolean[V], adj);
    }

}
