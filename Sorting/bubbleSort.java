package Sorting;

import java.util.Arrays;
//O(n^2) time in worst case and O(n) time in best case (this will be possible only if input array is already sorted)
//O(1) space
public class bubbleSort {
    
    public static int[] bubblesort(int[] array) {
        if(array.length == 0)
        return new int[] {};

        boolean isSorted = false;
        int counter = 0;

        while(!isSorted){
            isSorted = true;

            for(int i = 0; i < array.length - 1 - counter; i++){

                if(array[i] > array[i+1]){
                    swap(i, i+1, array);
                    isSorted = false;
                }
            }
            counter++;
        }

        return array;
    }

    public static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubblesort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }
}
