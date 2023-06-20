package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

// Find Minimum number of squares whose sum equals to given number n


public class DP2 {
    
    //Recursive
    public static int minSquare(int n){
        if(n <= 3){
            return n;
        }

        int res = Integer.MAX_VALUE;
        //int res = 0;

        int a = (int)Math.sqrt(n);
        for(int i = 1; i <= a; i++){
            //res = 1+minSquare(n - i*i);
            res = Math.min(res, 1 + minSquare(n-i*i));
        }

        return res;
    }

    //Using Dynamic Programming : Top Down Approach
    public static int minSquareDP(int n, int[] dp){
        if(n <= 3){
            return n;
        }

        if(dp[n] != Integer.MAX_VALUE)
        return dp[n];

        int a = (int)Math.sqrt(n);
        for(int i = 1; i <= a; i++){
            dp[n] = Math.min(dp[n], 1 + minSquareDP(n - i*i, dp));
        }

        return dp[n];
    }

    //Using Dynamic Programming : Bottom Up Approach

    public static int minSquareDP2(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 1; i*i <= n; i++){
            for(int j = 0; i*i+j <= n; j++ ){
                dp[i*i+j] = Math.min(dp[i*i+j], 1+dp[j]);
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        // int res = minSquare(100);
        // System.out.println(res);

        int n = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        
        // int res2 = minSquareDP(n,dp);
        // System.out.println(res2);

        int res3 = minSquareDP2(n,dp);
        System.out.println(res3);
    }
}
