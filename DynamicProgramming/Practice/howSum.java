package DynamicProgramming.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class howSum {

    //O(n^m * m) time and O(m) space
    public static List<Integer> howSumRec(int targetSum, int[] numbers) {
        if(targetSum == 0)
        return new ArrayList<>();

        if(targetSum < 0)
        return null;

        for(int num : numbers){
            int remainder = targetSum - num;

            if(howSumRec(remainder, numbers) != null){
                List<Integer> res = new ArrayList<Integer>();
                res = howSumRec(remainder, numbers);
                res.add(num);
                return res;
            }
        }

        return null;
    }


    //O(m^2*n) time and O(m^2) space
    public static ArrayList<Integer> howSumMemo(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> memo) {
        if(memo.containsKey(targetSum))
        return memo.get(targetSum);

        if(targetSum == 0)
        return new ArrayList<>();

        if(targetSum < 0)
        return null;

        for(int num : numbers){
            int remainder = targetSum - num;

            if(howSumMemo(remainder, numbers, memo) != null){
                ArrayList<Integer> res = new ArrayList<Integer>();
                res = howSumMemo(remainder, numbers, memo);
                res.add(num);
                memo.put(targetSum, res);
                return res;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    //O(m^2*n) time and O(m^2) space
    public static List<Integer> howSumTabulation(int targetSum, int[] numbers) {
        List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum+1, null));
        table.set(0, new ArrayList<>());

        for(int i = 0; i<= targetSum; i++){
            if(table.get(i) != null){
                for(int num : numbers){

                    if(i + num <= targetSum){
                    table.set(i+num, new ArrayList<>(table.get(i)));
                    table.get(i+num).add(num);
                    }
                }
            }
        }

        return table.get(targetSum);
    }


    public static void main(String[] args) {
        //System.out.println(howSumRec(7, new int[] {5, 3, 4, 7}));
        //System.out.println(howSumRec(300, new int[] {7, 14}));   


        System.out.println(howSumMemo(7, new int[] {5, 3, 4, 7}, new HashMap<>()));
        System.out.println(howSumMemo(700, new int[] {7, 14,10}, new HashMap<>()));
        
        // System.out.println(howSumTabulation(7, new int[] {5, 3, 4, 7}));
        // System.out.println(howSumTabulation(700, new int[] {14,10}));
    }
}
