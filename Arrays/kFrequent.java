
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class sortByValue implements Comparator<Map.Entry<Integer, Integer>>{
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
        if(o1.getValue() == o2.getValue()){
            return o2.getKey() - o1.getKey();
        }
        else{
            return o2.getValue() - o1.getValue();
        }
    }
}

public class kFrequent {

    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[k];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new sortByValue());
        
        for(int i = 0; i < k; i++){
            result[i] = list.get(i).getKey();
        }
        
        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Using Priority Queue

    public static int[] topKFrequentUsingPQ(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[k];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
            (a, b) -> a.getValue() == b.getValue() ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(b.getValue(), a.getValue()));

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                queue.add(entry);
            }

            for(int i = 0; i < k; i++){
                result[i] = queue.remove().getKey();
            }

            return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;

        int[] result = topKFrequent(array, k);
        System.out.println(Arrays.toString(result));

        int[] result2 = topKFrequentUsingPQ (array, k);
        System.out.println(Arrays.toString(result2));
    }
}
