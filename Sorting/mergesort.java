package Sorting;

import java.util.Arrays;

public class mergesort {
    
    public static int[] mergeSort(int[] array) {
        if(array.length <= 1)
        return array;

        int middle = (0+ array.length - 1) / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middle+1);
        int[] rightHalf = Arrays.copyOfRange(array, middle+1, array.length);

        int[] sortedLeft = mergeSort(leftHalf);
        int[] sortedRight = mergeSort(rightHalf);

        return mergeSortedArray(sortedLeft, sortedRight);
    }

    public static int[] mergeSortedArray(int[] leftHalf, int[] rightHalf){
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];
        int i = 0; 
        int j = 0;
        int k = 0;

        while(i < leftHalf.length && j < rightHalf.length){
            if(leftHalf[i] <= rightHalf[j]){
                sortedArray[k++] = leftHalf[i++];
            }
            else{
                sortedArray[k++] = rightHalf[j++];
            }
        }

        while(i < leftHalf.length){
            sortedArray[k++] = leftHalf[i++];
        }
        
        while(j < rightHalf.length){
            sortedArray[k++] = rightHalf[j++];
        }

        return sortedArray;
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    //Optimised space with Auxiliary Array

    public static int[] mergeSort2(int[] array) {
        if(array.length <= 1)
        return array;

        int[] auxilliaryArray = array.clone();
        mergeSort2(array, 0, array.length-1, auxilliaryArray);
        
        return array;
    }

    public static void mergeSort2(int[] mainArray, int start, int end, int[] auxilliaryArray) {
        if(start == end)
        return;

        int middle = (start + end) / 2;
        mergeSort2(auxilliaryArray, start, middle, mainArray);
        mergeSort2(auxilliaryArray, middle+1, end, mainArray);
        doMerge(mainArray, start, middle, end, auxilliaryArray);
    }

    public static void doMerge(int[] mainArray, int start, int middle, int end, int[] auxilliaryArray) {
        int k = start;
        int i = start;
        int j = middle + 1;

        while(i <= middle && j <= end){
            if(auxilliaryArray[i] <= auxilliaryArray[j]){
                mainArray[k++] = auxilliaryArray[i++];
            }
            else{
                mainArray[k++] = auxilliaryArray[j++];
            }
        }

        while(i <= middle){
            mainArray[k++] = auxilliaryArray[i++];
        }

        while(j <= end){
            mainArray[k++] = auxilliaryArray[j++];
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    //Optimised without auxiliary array


    public static int[] mergeSort3(int[] array) {
        if(array.length <= 1)
        return array;

        mergeSort3(array, 0, array.length-1);
        
        return array;
    }

    public static void mergeSort3(int[] array, int left, int right) {
        if(left >= right)
        return;

        int middle = (left + right) / 2;

        mergeSort3(array, left, middle);
        mergeSort3(array, middle + 1, right);
        mergeSortedArray3(array, left, middle, right);

    }

    public static void mergeSortedArray3(int[] array, int left, int middle, int right) {
        
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right+1);

        int i = 0, j = 0, k = left;

        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] <= rightArray[j]){
                array[k++] = leftArray[i++];
            }
            else{
                array[k++] = rightArray[j++];
            }
        }

        while(i < leftArray.length){
            array[k++] = leftArray[i++];
        }

        while(j < rightArray.length){
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
     System.out.println(Arrays.toString(mergeSort(new int[] {8, 5, 2, 9, 5, 6, 3})));   
     System.out.println(Arrays.toString(mergeSort2(new int[] {8, 5, 2, 9, 5, 6, 3}))); 
     System.out.println(Arrays.toString(mergeSort3(new int[] {8, 5, 2, 9, 5, 6, 3})));   
    }
}
