package Searching;

public class quickSelect {
    //This is Searching algorithm based on quicksort    
    public static int quickselect(int[] array, int k) {
        int position = k - 1;
        return quickSelectHelper(array, 0, array.length-1, position);
    }

    public static int quickSelectHelper(int[] array, int start, int end, int position) {
        while(true){
            
            int pivot = start;
            int left = start + 1;
            int right = end;

            while(left <= right){
                if(array[left] > array[pivot] && array[right] < array[pivot]){
                    swap(left, right, array);
                }
                if(array[left] <= array[pivot]){
                    left++;
                }
                if(array[right] >= array[pivot]){
                    right--;
                }
            }
            swap(right, pivot, array);

            if(right == position){
                return array[right];
            }
            else if(position > right){
                start = right + 1;
            }
            else{
                end = right - 1;
            }
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(quickselect(new int[] {8, 5, 2, 9, 7, 6, 3}, 3));
    }
}
