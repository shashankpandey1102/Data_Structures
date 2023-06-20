package DynamicProgramming.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class bestSum {
    
    //O(n^m * m) space and O(m^2) space
    public static List<Integer> bestSumRec(int targetSum, int[] numbers) {
        if(targetSum == 0)
        return new ArrayList<>();

        if(targetSum < 0)
        return null;

        List<Integer> shortestPath = null;

        for(int num : numbers){
            int remainder = targetSum - num;

            List<Integer> check = bestSumRec(remainder, numbers);

            if(check != null){
                List<Integer> combination = new ArrayList<Integer>();
                combination.add(num);
                combination.addAll(check);

                if(shortestPath == null || combination.size() < shortestPath.size())
                shortestPath = combination;
            }
        }

        return shortestPath;
    }

    //O(m^2*n) time and O(m^2) space
    public static List<Integer> bestSumMemo(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memo) {
        if(memo.containsKey(targetSum))
        return memo.get(targetSum);
        
        if(targetSum == 0)
        return new ArrayList<>();

        if(targetSum < 0)
        return null;

        List<Integer> shortestPath = null;

        for(int num : numbers){
            int remainder = targetSum - num;

            List<Integer> check = bestSumMemo(remainder, numbers, memo);

            if(check != null){
                List<Integer> combination = new ArrayList<Integer>();
                combination.add(num);
                combination.addAll(check);

                if(shortestPath == null || combination.size() < shortestPath.size())
                shortestPath = combination;
            }
        }

        memo.put(targetSum, shortestPath);
        return shortestPath;
    }
    

    //O(m^2 * n) time and O(m^2) space
    public static List<Integer> bestSumTabulation(int targetSum, int[] numbers) {
        List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum+1, null));
        table.set(0, new ArrayList<>());

        for(int i = 0; i <= targetSum; i++){
            if(table.get(i) != null){
                for(int num : numbers){
                    List<Integer> combination = new ArrayList<>();
                    
                    if(i+num <= targetSum){
                        combination.add(num);
                        combination.addAll(table.get(i));
                    

                    if(table.get(i+num) == null || combination.size() < table.get(i).size())
                    table.set(i+num, combination);  
                    
                    }                  

                }
            }
        }

        return table.get(targetSum);
    }

    public static void main(String[] args) {
        // System.out.println(bestSumRec(7, new int[] {5, 3, 4, 7}));

        System.out.println(bestSumMemo(2000, new int[] {10, 50, 1000}, new HashMap<>()));

        //System.out.println(bestSumTabulation(7, new int[] {5, 3, 4, 7}));
    }
}
