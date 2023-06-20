package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class fourSum {
    
    static class pair{
        int first;
        int second;

        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        
        List<Integer[]> result = new ArrayList<Integer[]>();
        HashMap<Integer, pair> map = new HashMap<Integer, pair>();

        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                map.put(array[i] + array[j], new pair(i, j));
            }
        }

        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                int sum = array[i] + array[j];

                if(map.containsKey(targetSum - sum)){
                    pair p = map.get(targetSum - sum);

                    if(p.first != i && p.first != j && p.second != i && p.second != j){
                        Integer[] pairs = {p.first, p.second, i, j};
                        result.add(pairs);
                    }
                }
            }
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> fourNumberSum2(int[] array, int targetSum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(array);
        int n = array.length;

        for(int i = 0; i < n-3; i++){
            for(int j = i+1; j < n-2; j++){
                int req = targetSum - array[i] - array[j];
                int start = j+1;
                int end = n-1;

                while(start < end){
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    
                    if(array[start] + array[end] == req){
                        al.add(array[i]);
                        al.add(array[j]);
                        al.add(array[start]);
                        al.add(array[end]);

                        result.add(al);

                        start++;
                        end--;
                    }
                    else if(array[start] + array[end] < req){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;

        System.out.println(fourNumberSum2(array, targetSum));
    }
}
