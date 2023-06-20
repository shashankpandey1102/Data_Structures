package DynamicProgramming.Practice;

import java.util.HashMap;

public class canSum {
    //let n be the length of numbers and m is targetSum

    //O(n^m) time and O(m) space
    public static boolean canSumRec(int targetSum , int[] numbers) {
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int num : numbers){
            int remainder = targetSum - num;

            if(canSumRec(remainder, numbers)){
                return true;
            }
        }

        return false;
    }
    
    //O(m*n) time and O(m) space
    public static boolean canSumMemo(int targetSum , int[] numbers, HashMap<Integer, Boolean> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);

        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int num : numbers){
            int remainder = targetSum - num;

            if(canSumMemo(remainder, numbers, memo)){
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }


    //O(mn) time and O(m) space
    public static boolean canSumTabulation(int targetSum, int[] numbers) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;

        for(int i = 0; i <= targetSum; i++){
            if(table[i]){
                for(int num : numbers){

                    if(i+num <= targetSum)
                    table[i + num] = true;
                }
            }
        }

        return table[targetSum];
    }
    public static void main(String[] args) {
        
        // System.out.println(canSumRec(7, new int[] {5, 3, 4, 7}));
        // System.out.println(canSumRec(300, new int[] {7, 14}));

        // System.out.println(canSumMemo(7, new int[] {5, 3, 4, 7}, new HashMap<Integer, Boolean>()));
        // System.out.println(canSumMemo(10000, new int[] {7, 14}, new HashMap<Integer, Boolean>()));

        System.out.println(canSumTabulation(7, new int[] {5, 3, 4, 7}));
        System.out.println(canSumTabulation(300, new int[] {7, 14}));
    }
}
