package Arrays;

import java.util.*;

public class threeSum {
    
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        Arrays.sort(array);
        

        for(int i = 0 ; i < array.length; i++){
            int left = i+1;
            int right = array.length - 1;

            while(left < right){
                int calculatedSum = array[i] + array[left] + array[right];
                if(calculatedSum == targetSum){
                    Integer[] res = new Integer[3];
                    res[0] = array[i];
                    res[1] = array[left];
                    res[2] = array[right];

                    list.add(res);
                    left++;
                    right--;
                }
                else if(calculatedSum < targetSum){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return list;
      }

    public static void main(String[] args) {
        System.out.println(threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0));
    }
}
