package DynamicProgramming.Practice;

import java.util.HashMap;

public class GridTraveller {
    
    //O(2^(m+n)) time and O(m+n) space
    public static int gridTravellerRec(int m, int n) {
        if(m == 0 || n == 0)
        return 0;

        if(m == 1 && n == 1)
        return 1;

        return gridTravellerRec(m-1, n) + gridTravellerRec(m, n-1);
    }

    //O(m*n) time and O(m+n) space
    public static long gridTravellerMemo(int m, int n, long[][] memo) {
        if(memo[m][n] != 0){
            return memo[m][n];
        }

        if(m == 0 || n == 0){
            memo[m][n] = 0;
            return 0;
        }
        

        if(m == 1 && n == 1){
            memo[m][n] = 1;
            return 1;
        }
        

        memo[m][n] = gridTravellerMemo(m-1, n, memo) + gridTravellerMemo(m, n-1, memo); 
        return memo[m][n];
    }

    //O(m*n) time and O(m*n) space
    public static long gridTravellerTabulation(int m, int n) {
        long[][] table = new long[m+1][n+1];
        table[1][1] = 1;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i+1 <= m) table[i+1][j] += table[i][j];
                if(j+1 <= n) table[i][j+1] += table[i][j]; 
            }
        }

        return table[m][n];
    }


    public static int gridTravellerMemo2(int m, int n, HashMap<String, Integer> memo) {
        if(memo.containsKey(m + ","+ n)){
            return memo.get(m + "," + n);
        }

        if(m == 0 || n == 0){
            memo.put(m + "," + n, 0);
            return 0;
        }
        

        if(m == 1 && n == 1){
            memo.put(m + "," + n, 1);
            return 1;
        }
        
        memo.put(m + "," + n, gridTravellerMemo2(m-1, n, memo) + gridTravellerMemo2(m, n-1, memo));
        //memo[m][n] = gridTravellerMemo(m-1, n, memo) + gridTravellerMemo(m, n-1, memo); 
        return memo.get(m + "," + n);
    }

    public static void main(String[] args) {
        //System.out.println(gridTravellerRec(20, 20));
        System.out.println(gridTravellerMemo(18, 18, new long[50][50]));
        System.out.println(gridTravellerTabulation(18, 18));
    }
}
