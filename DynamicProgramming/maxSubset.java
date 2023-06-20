package DynamicProgramming;

//https://www.youtube.com/watch?v=VT4bZV24QNo

import java.util.Arrays;

public class maxSubset {

    public static int maxSubsetSumRec(int[] array, int idx) {
        if(idx >= array.length-1)
        return 0;

        int first = array[idx];
        int second = array[idx+1];

        int max1 = Math.max(first+maxSubsetSumRec(array, idx+2), first+maxSubsetSumRec(array, idx+3));
        int max2 = Math.max(second+maxSubsetSumRec(array, idx+3), second+maxSubsetSumRec(array, idx+4));

        int max = Math.max(max1, max2);

        return max;
    }
    
    public static int maxSubsetSum(int[] array, int idx, int[] memo) {
        if(memo[idx] != 0)
        return memo[idx];

        if(idx >= array.length-1)
        return 0;

        int first = array[idx];
        int second = array[idx+1];

        int max1 = Math.max(first+maxSubsetSum(array, idx+2, memo), first+maxSubsetSum(array, idx+3, memo));
        int max2 = Math.max(second+maxSubsetSum(array, idx+3, memo), second+maxSubsetSum(array, idx+4, memo));

        int max = Math.max(max1, max2);

        memo[idx] = max;
        return memo[idx];
    }

    public static int maxSubsetSumPep(int[] array) {
        int inc = array[0];
        int exc = 0;

        for(int i = 1; i < array.length; i++){
            int newInc = exc + array[i];
            int newExc = Math.max(inc, exc);

            inc = newInc;
            exc = newExc;
        }

        int res = Math.max(inc, exc);
        return res;
    }

    

    public static void main(String[] args) {
     
        System.out.println(maxSubsetSum(new int[] {7,10,12,7,9,14}, 0, new int[10]));
        System.out.println(maxSubsetSumRec(new int[] {7,10,12,7,9,14}, 0));
        System.out.println(maxSubsetSumPep(new int[] {7,10,12,7,9,14}));
        
    }
}
