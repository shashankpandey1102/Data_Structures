package Sorting;

import java.util.Arrays;

public class threeNumSort {
    
    public static int[] threeNumberSort(int[] array, int[] order) {
        int count1 = 0; 
        int count2 = 0;
        int count3 = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == order[0])
            count1++;
            else if(array[i] == order[1])
            count2++;
            else if(array[i] == order[2])
            count3++;
        }
        System.out.println(count1 +"  " + count2 + "  " + count3);

        for(int i = 0; i < count1; i++){
            array[i] = order[0];
        }
        for(int i = count1; i < count1 + count2; i++){
            array[i] = order[1];
        }
        for(int i = count1 + count2; i < count1 + count2 + count3; i++){
            array[i] = order[2];
        }

        return array;
    }

    public static int[] threeNumberSort2(int[] array, int[] order) {
        int first = 0;
        int second = 0;
        int third = array.length-1;

        while(second <= third){
            if(array[second] == order[0]){
                swap(first, second, array);
                first++;
                second++;
            }
            else if(array[second] == order[1]){
                second++;
            }
            else if(array[second] == order[2]){
                swap(second, third, array);
                third--;
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
        System.out.println(Arrays.toString(threeNumberSort(new int[] {1, 0, 0, -1, -1, 0, 1, 1}, new int[] {0, 1, -1})));
        System.out.println(Arrays.toString(threeNumberSort2(new int[] {1, 0, 0, -1, -1, 0, 1, 1}, new int[] {0, 1, -1})));
    }
}
