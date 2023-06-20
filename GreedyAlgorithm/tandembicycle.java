package GreedyAlgorithm;

import java.util.Arrays;

public class tandembicycle {
    
    public static int tandemBicycle(int[] redShirtSpeeds, int[] bluShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(bluShirtSpeeds);

        int tandomSpeed = 0;
        int totalTandomSpeed = 0;

        if(fastest == true){
            for(int i = 0, j = bluShirtSpeeds.length - 1; i < redShirtSpeeds.length && j >= 0; i++,j--){
                tandomSpeed = Math.max(redShirtSpeeds[i], bluShirtSpeeds[j]);
                totalTandomSpeed += tandomSpeed;
            }
        }
        else{
            for(int i = 0; i < redShirtSpeeds.length; i++){
                tandomSpeed = Math.max(redShirtSpeeds[i], bluShirtSpeeds[i]);
                totalTandomSpeed += tandomSpeed;
            }
        }


        return totalTandomSpeed;
    }

    public static void main(String[] args) {
        System.out.println(tandemBicycle(new int[] {5, 5, 3, 9, 2}, new int[] {3, 6, 7, 2, 1}, false));
    }
}
