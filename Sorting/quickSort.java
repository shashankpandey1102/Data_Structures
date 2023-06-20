package Sorting;

import java.util.Arrays;

public class quickSort {

    public static int[] Sort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
        return array;
    }

    public static void quickSortHelper(int[] array, int start, int end) {
        if(start >= end)
        return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            if(array[left] > array[pivot] && array[right] < array[pivot]){
                swap(array, left, right);
            }
            if(array[left] <= array[pivot]){
                left++;
            }
            if(array[right] >= array[pivot]){
                right--;
            }
        }
        swap(array, pivot, right);

        quickSortHelper(array, start, right-1);
        quickSortHelper(array, right+1, end);
    }

    public static void swap(int[] array, int i, int j) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp; 
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Sort(new int[] {8, 5, 2, 9, 5, 6, 3})));
    }
}
