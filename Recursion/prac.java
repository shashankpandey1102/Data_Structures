package Recursion;
import java.sql.Array;
import java.util.*;
//Print permutation

public class prac {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();

        getPermutation(0, nums, permutation);
        
        return permutation;
    }

    public static void getPermutation(int index, int[] nums, List<List<Integer>> permutation ) {
       if(index == nums.length-1){
        permutation.add(convert(nums));
        return;
       }

        for(int j = index; j < nums.length; j++){
            swap(index, j, nums);
            getPermutation(index+1, nums, permutation);
            swap(index, j, nums);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<Integer> convert(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length;i++){
            res.add(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        res = permute(nums);
        System.out.println(res);
    }
}
