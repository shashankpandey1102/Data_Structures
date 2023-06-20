package Sorting;

import java.util.Arrays;
// The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
// from the unsorted part and putting it at the beginning.

public class selectionSort {
    
    public static int[] selectionsort(int[] array) {
        if(array.length == 0)
        return new int[] {};

        int start = 0;

        while(start < array.length-1){
            int small = start;
            
            for(int i = start + 1; i < array.length; i++){
                if(array[i] < array[small])
                small = i;
            }

            swap(start, small, array);
            start++;
        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionsort(new int[] {8, 5, 2, 9, 5, 6, 3})));
    }
}
