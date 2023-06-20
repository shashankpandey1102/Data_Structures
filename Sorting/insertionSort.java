package Sorting;

import java.util.Arrays;

public class insertionSort {
    
    public static int[] insertionsort(int[] array) {
        if(array.length == 0)
        return new int[] {};

        for(int i = 1; i < array.length; i++){
            int j = i;

            while(j > 0 && array[j] < array[j-1]){
                swap(j, j-1, array);
                j--;
            }
        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionsort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }
}
