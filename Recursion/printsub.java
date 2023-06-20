package Recursion;
import java.util.*;

public class printsub {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        helper(nums, 0, res, ans, set);

        return res;
    }

    public static void helper(int[] nums, int i, List<List<Integer>> res, List<Integer>  ans, HashSet<List<Integer>> set){
        if(i == nums.length){
            List<Integer> check = new ArrayList<>(ans);
            Collections.sort(check);
            if(set.contains(check)){
                return;
            }
            else{
                res.add(new ArrayList<>(ans));
                set.add(check);
                return;
            }
        }

        ans.add(nums[i]);
        helper(nums, i+1, res, ans, set);

        ans.remove(ans.size()-1);
        helper(nums, i+1, res, ans, set);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new int[] {1, 2, 2}, 0, res, new ArrayList<>(), new HashSet<>());
        System.out.println(res);

        List<List<Integer>> res1 = subsetsWithDup(new int[] {1, 2, 2});
        System.out.println(res1);

    }
}
