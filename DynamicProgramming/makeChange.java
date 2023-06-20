package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class makeChange {
    

    public static int numberOfWaysToMakeChange(int n, int[] denoms, int index) {

        if(n == 0) return 1;

        int ways = 0;

        for(int i = index; i < denoms.length; i++){
            if(n - denoms[i] >= 0){
                int numOfWays = numberOfWaysToMakeChange(n-denoms[i], denoms, i);
                ways += numOfWays;
            }
        }

        return ways;
    }

    public static int numberOfWaysToMakeChangeMemo(int n, int[] denoms, int index, int[][] memo) {
        if(memo[index][n] != 0)
        return memo[index][n];

        if(n == 0) return 1;

        int ways = 0;

        for(int i = index; i < denoms.length; i++){
            if(n - denoms[i] >= 0){
                int numOfWays = numberOfWaysToMakeChangeMemo(n-denoms[i], denoms, i, memo);
                ways += numOfWays;
            }
        }

        memo[index][n] = ways;
        return memo[index][n];
    }

    public static int numberOfWaysToMakeChangeTabulation(int n, int[] denoms) {

        int[] table = new int[n+1];
        table[0] = 1;
        for(int num : denoms){
            for(int amount = 1; amount <= n; amount++){
                if(num <= amount){
                    table[amount] +=table[amount - num];
                }
            }
        }

        System.out.println(Arrays.toString(table));
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChangeTabulation(6, new int[] {1,5}));
        //System.out.println(numberOfWaysToMakeChangeMemo(6, new int[] {5, 1}, 0, new int[2][7]));
        // System.out.println(numberOfWaysToMakeChangeMemo(0, new int[] {2, 3, 4, 7}, 0, new int[4][1]));
        // System.out.println(numberOfWaysToMakeChangeMemo(9, new int[] {5}, 0, new int[1][10]));
        // System.out.println(numberOfWaysToMakeChangeMemo(7, new int[] {2, 4}, 0, new int[2][8]));
        // System.out.println(numberOfWaysToMakeChangeMemo(4, new int[] {1, 5, 10, 25}, 0, new int[4][5]));
        // System.out.println(numberOfWaysToMakeChangeMemo(5, new int[] {1, 5, 10, 25}, 0, new int[4][6]));
        // System.out.println(numberOfWaysToMakeChangeMemo(10 ,new int[] {1, 5, 10, 25}, 0, new int[4][11]));
        // System.out.println(numberOfWaysToMakeChangeMemo(25, new int[] {1, 5, 10, 25}, 0, new int[4][26]));
        // System.out.println(numberOfWaysToMakeChangeMemo(12, new int[] {2, 3, 7}, 0, new int[3][13]));
        // System.out.println(numberOfWaysToMakeChangeMemo(7, new int[] {2, 3, 4, 7}, 0, new int[4][8]));
    
    
    
    }
}
