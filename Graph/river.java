package Graph;
import java.util.*;

public class river {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(visited[i][j])
                continue;

                traverseNode(i, j, matrix, visited, sizes);
            }
        }

        return sizes;
    }

    public static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentSize = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            i = curr[0];
            j = curr[1];
            
            if(visited[i][j])
            continue;

            visited[i][j] = true;
            if(matrix[i][j] == 0)
            continue;

            currentSize++;
            List<int[]> unvisited = getUnvisited(i, j, matrix, visited);

            for(int[] neighbor : unvisited){
                q.add(neighbor);
            }
        }

        if(currentSize > 0)
        sizes.add(currentSize);
    }

    public static List<int[]> getUnvisited(int i, int j, int[][] matrix, boolean[][] visited){
        List<int[]> unvisited = new ArrayList<>();

        if(i > 0 && !visited[i-1][j])           //UP
        unvisited.add(new int[] {i-1, j});

        if(i < matrix.length && !visited[i+1][j])       //Down
        unvisited.add(new int[] {i+1, j});

        if(j > 0 && !visited[i][j-1])       //Left
        unvisited.add(new int[] {i, j-1});

        if(j < matrix[0].length && !visited[i][j+1])        //Right
        unvisited.add(new int[] {i, j+1});

        return unvisited;
    }
}
