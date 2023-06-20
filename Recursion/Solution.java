package Recursion;
import java.util.*;

public class Solution {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subSet(nums, 0, ans, list);
        return ans;
    }

    public static void subSet(int[] nums, int idx,List<List<Integer>> ans,List<Integer> list) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            //skip the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res = subsetsWithDup(new int[] {1, 2, 2});
        System.out.println(res);
    }
}