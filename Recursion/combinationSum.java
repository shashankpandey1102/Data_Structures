package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class combinationSum {
    
    public static List<List<Integer>> combinationsum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        //helper(0, candidates, target, ans, res);
        helper2(0, candidates, target, ans, res);

        return res;
    }

    public static void helper(int i, int[] candidates, int target, List<Integer> ans, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target < 0 || i >= candidates.length)
        return;

        ans.add(candidates[i]);
        helper(i, candidates, target-candidates[i], ans, res);

        ans.remove(ans.size()-1);
        helper(i+1, candidates, target, ans, res);
    }

    public static void helper2(int i, int[] candidates, int target, List<Integer> ans, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(ans));
            
         }
        if(target < 0)
         return;
        
         
        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1])
            continue;

            ans.add(candidates[j]);
            helper2(j+1, candidates, target-candidates[j], ans, res);
            ans.remove(ans.size()-1);
        }
        
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res = combinationsum(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(res);
    }
}
