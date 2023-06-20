package Recursion;

import java.util.HashMap;

public class staircase {
    public static int staircaseTraversal1(int height, int maxSteps){
        if(height <= 1)
        return 1;

        //i == steps which we take
        int numberOfWays = 0;
        for(int i = 1; i < Math.min(height, maxSteps) + 1; i++){
            numberOfWays += staircaseTraversal1(height - i, maxSteps);
        }

        return numberOfWays;
    }

    //Memoization
    public static int staircaseTraversal2(int height, int maxSteps, HashMap<Integer, Integer> map) {
        if(map.containsKey(height)){
            return map.get(height);
        }

        if(height <= 1){
            return 1;
        }

        //i == steps which we take
        int numberOfWays = 0;
        for(int i = 1; i < Math.min(height, maxSteps) + 1; i++){
            numberOfWays += staircaseTraversal2(height - i, maxSteps, map);
        }

        map.put(height, numberOfWays);
        return numberOfWays;
    }

    //Tabulation
    public static int staircaseTraversal2(int height, int maxSteps){
        int[] table = new int[height+1];
        table[0] = 1;
        table[1] = 1;

        for(int i = 2; i < height+1; i++){
            int step = 1;
            while(step <= maxSteps && step <= i){
                table[i] = table[i] + table[i-step];
                step++;
            }
        }

        return table[height];
    }

    //Sliding Window
    public static int staircaseTraversal3(int height, int maxSteps) {
        int ways = 0;
        int[] arr = new int[height + 1];
        arr[0] = 1;

        //i == current height
        for(int i = 1; i < height + 1; i++){
            int start = i - maxSteps - 1;
            int end = i - 1;

            if(start >= 0){
                ways -= arr[start];
            }

            ways += arr[end];
            arr[i] = ways;
        }

        return arr[height];
    }
    public static void main(String[] args) {
         int res = staircaseTraversal1(50, 10);
         //int res1 = staircaseTraversal2(50, 10, new HashMap<>());
        // int res2 = staircaseTraversal2(4, 2);
        //int res3 = staircaseTraversal3(4, 2);

        System.out.println(res);
    }
}
