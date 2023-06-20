package Arrays;

import java.util.Arrays;

public class sortedsquare {

    public static int[] sortedSquaredArray(int[] array) {
        int left = 0;
        int right = array.length-1;
        int j = array.length-1;
        int[] res = new int[array.length];

        while(right >= left){
            if(Math.abs(array[left])> Math.abs(array[right])){
                res[j] = array[left] * array[left];
                left++;
                j--;
            }
            else{
                res[j] = array[right] * array[right];
                right--;
                j--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-9, -4, -3, 1, 2, 5, 7})));
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-2, -1})));
    }
}
