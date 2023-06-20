package Graph;
import java.util.*;

public class minimumPass {
    public int minimumPassesOfMatrix(int[][] matrix) {
        int passes = convertMatrix(matrix);
        return containsNegetive(matrix) ? -1 : passes-1;
    }

    public int convertMatrix(int[][] matrix) {
        List<int[]> q = getPositive(matrix);
        int passes = 0;

        while(!q.isEmpty()){
            int currentSize = q.size();

            while(currentSize > 0){
                int[] curr = q.remove(0);
                int i = curr[0];
                int j = curr[1];

                List<int[]> neighbors = getNeighbors(i, j, matrix);
                for(int[] neighbor : neighbors){
                    int row = neighbor[0];
                    int col = neighbor[1];

                    if(matrix[row][col] < 0){
                        matrix[row][col] *= -1;
                        q.add(new int[] {row, col});
                    }
                }

                currentSize--;
            }
            passes++;
        }

        return passes;
    }

    public List<int[]> getNeighbors(int i, int j, int[][] matrix) {
        List<int[]> list = new ArrayList<>();

        if(i > 0)
        list.add(new int[] {i - 1, j});

        if(i < matrix.length - 1)
        list.add(new int[] {i + 1, j});

        if(j > 0)
        list.add(new int[] {i, j - 1});

        if(j < matrix[i].length - 1)
        list.add(new int[] {i, j + 1});

        return list;
    }

    public List<int[]> getPositive(int[][] matrix){
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] > 0){
                    list.add(new int[] {i, j});
                }
            }
        }

        return list;
    }

    public boolean containsNegetive(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] < 0)
                return true;
            }
        }

        return false;
    }
}
