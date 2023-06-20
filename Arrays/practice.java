package Arrays;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
public class practice {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= nums.length - k; i++){
            int[] subArray = Arrays.copyOfRange(nums, i, i+k);
            int max = findMaxFromArray(subArray);
            list.add(max);
        }
        
        int[] result = convert(list);
        return result;
    }
    
    public static int findMaxFromArray(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] > max){
                max = nums[i];
            }
            
        }
        
        return max;
    }
    
    public static int[] convert(ArrayList<Integer> list){
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
