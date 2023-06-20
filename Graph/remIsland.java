package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class remIsland {
    public int[][] removeIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){

                boolean rowIsBorder = i == 0 || i == matrix.length - 1;
                boolean colIsBorder = j == 0 || j == matrix[0].length - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if(!isBorder)
                continue;

                if(matrix[i][j] == 0)
                continue;

                findOnesConnectedWithBorder(i, j, matrix, visited);
            }
        }

        for(int i = 1; i < matrix.length - 1; i++){
            for(int j = 1; j < matrix[i].length - 1; j++){
                if(visited[i][j])
                continue;

                matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    public void findOnesConnectedWithBorder(int i, int j, int[][] matrix, boolean[][] visited) {
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

            List<int[]> neighbors = getNeighbors(i, j, matrix);
            for(int[] neighbor : neighbors){
                q.add(neighbor);
            }
        }
    }

    public List<int[]> getNeighbors(int i, int j, int[][] matrix){
        List<int[]> list = new ArrayList<>();

        if(i > 0)
        list.add(new int[] {i-1, j});

        if(i < matrix.length-1)
        list.add(new int[] {i+1, j});

        if(j > 0)
        list.add(new int[] {i, j-1});

        if(j < matrix[i].length-1)
        list.add(new int[] {i, j+1});

        return list;
    }
}
