package DynamicProgramming;
import java.util.Arrays;

public class minCoins {
    public static int minCoinsRec(int n, int[] denoms) {
        if(n == 0)
        return 0;

        if(n < 0)
        return Integer.MAX_VALUE;

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < denoms.length; i++){
            int subRes = minCoinsRec(n - denoms[i], denoms);

            if(subRes != Integer.MAX_VALUE){
                res = Integer.min(res, subRes+1);
            }
        }

        return res;
    }

    public static int minCoinsMemo(int n, int[] denoms, int[] memo) {
        if(memo[n] != 0)
        return memo[n];

        if(n == 0)
        return 0;

        if(n < 0)
        return Integer.MAX_VALUE;

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < denoms.length; i++){
            if(n-denoms[i] >= 0){
            int subRes = minCoinsMemo(n - denoms[i], denoms, memo);

            if(subRes != Integer.MAX_VALUE){
                res = Integer.min(res, subRes+1);
            }
        }
        }

        memo[n] = res;
        return res;
    }

    public static int minCoinsTabulation(int n, int[] denoms) {
        int[] table = new int[n+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for(int i = 1; i <= n; i++){
            //trying to solve for every amount from 1 to n
            for(int num : denoms){

                if(i-num >= 0 && table[i-num] != Integer.MAX_VALUE)
                table[i] = Integer.min(table[i], 1+table[i-num]);

            }
        }

        if(table[n] == Integer.MAX_VALUE)
        return -1;

        return table[n];
    }

    public static void main(String[] args) {

        //size pf memo should be n+1
        int ans = minCoinsMemo(6, new int[] {1,2},new int[7]);

        if(ans != Integer.MAX_VALUE)
        System.out.println(ans);
        else
        System.out.println(-1);


        System.out.println(minCoinsTabulation(6, new int[]{1,2}));
    }
}
