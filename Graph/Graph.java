package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    //Representation of graph using adjacency matrix
    public static void adjMatrix(int n, int m) {
        
        int[][] adj = new int[n+1][n+1];

        for(int i = 0; i < m; i++){

            System.out.println("Enter connection " + (i+1) + " : ");
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

        //System.out.println(Arrays.deepToString(adj));

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        
        for(int i = 0; i < adj.size(); i++){

            //System.out.println("Adjacency List of Vertex : " +i);
            System.out.print(i);

            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }

    }

    //O(V+E) time and O(V)space where V is vertex and E is edge
    public static void BFS(int s, int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");
            
            // Iterator<Integer> itr = adj.get(s).listIterator();
            // while(itr.hasNext()){
            //     int n = itr.next();

            //     if(!visited[n]){
            //         visited[n] = true;
            //         queue.add(n);
            //     }
            // }

            for(int a : adj.get(s)){
                if(!visited[a]){
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }
    //O(V+E) time and O(V)space where V is vertex and E is edge
    public static void DFS(int s,boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        //Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        //queue.add(s);
        System.out.print(s + " ");
        Iterator<Integer> itr = adj.get(s).listIterator();
        while(itr.hasNext()){
            int n = itr.next();
            if(!visited[n])
            DFS(n, visited, adj);
        }
    }
    public static void main(String[] args) {
        
        //adjMatrix(4, 7);
        
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
        addEdge(adj, 2, 4);

        printGraph(adj);
        int start = 0;
        BFS(start, V, adj);
        System.out.println();


        boolean[] visited = new boolean[V];
        DFS(start, visited, adj);
    }
}
