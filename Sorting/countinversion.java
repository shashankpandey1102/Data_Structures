package Sorting;

import java.util.Arrays;

public class countinversion {
    
    public static int countInversion(int[] array){
        return countInversionHelper(array, 0, array.length-1);
    }

    public static int countInversionHelper(int[] array, int left, int right) {
        if(left >= right)
        return 0;

        int totalCount = 0;
        int middle = (left + right) / 2;

        int leftCount = countInversionHelper(array, left, middle);
        int rightCount = countInversionHelper(array, middle+1, right);
        int mergeCount = mergeAndCount(array, left, middle, right);

        totalCount = leftCount + rightCount + mergeCount;

        return totalCount;
    }

    public static int mergeAndCount(int[] array, int left, int middle, int right) {
        
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] <= rightArray[j]){
                array[k++] = leftArray[i++];
            }
            else{
                array[k++] = rightArray[j++];
                swaps += leftArray.length - i;
            }
        }

        while(i < leftArray.length){
            array[k++] = leftArray[i++];
        }

        while(j < rightArray.length){
            array[k++] = rightArray[j++];
        }

        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(countInversion(new int[] {2, 3, 3, 1, 9, 5, 6}));
    }
}
