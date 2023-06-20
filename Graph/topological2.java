package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class topological2 {

    public static List<List<Integer>> adj = new ArrayList<>();

    public static int[] findOrder(int numCourses, int[][] prerequisites){
        int[] topologicalOrder = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            visited[i] = false;
        }

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == false)
            topologicalOrder(i, visited, stack);
        }

        int i = numCourses - 1;
        while(!stack.isEmpty() && i >= 0){
            topologicalOrder[i] = stack.pop();
            i--;
        }

        return topologicalOrder;
    }

    public static void topologicalOrder(int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;

        for(int i = 0; i < adj.get(v).size(); i++){
            int check = adj.get(v).get(i);
            
            if(!visited[check])
            topologicalOrder(check, visited, stack);
        }

        stack.push(v);
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{2, 3}, {3, 1}, {4, 0}, {4, 1}, {5, 2}, {5, 0}};
        int[] result = findOrder(6, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}
