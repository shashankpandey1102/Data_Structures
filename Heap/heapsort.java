package Heap;

//O(n log n) time and O(1) space
public class heapsort {
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void print(int[] array) {
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    //use to build max heapify
    public static void maxHeapify(int[] array, int n, int i) {
        
        int largest = i;
        int left =  (2 * i) + 1;
        int right = (2 * i) + 2;

        if(left < n && array[left] > array[largest]){
            largest = left;
        }
        if(right < n && array[right] > array[largest]){
            largest = right;
        }

        if(largest != i){
            swap(largest, i, array);
            maxHeapify(array, n, largest);
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        //Creating Max Heap
        for(int i = n/2-1; i >= 0; i--){        //O(log n) time
            maxHeapify(array, n, i);
        }

        for(int i = n-1; i > 0; i--){           //O(n) time 
            
            //Step 1 : sawp root node(array[0]) with last node(array[i])
            swap(0, i, array);
            
            //Step 2: Take correct node at root by using heapify with less size
            //now n becomes i : since it is last index
            //and i becomes 0 because we have to apply max heapify at 0th index 
            maxHeapify(array, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] array = {54, 53, 55, 52, 50};
        heapSort(array);
        print(array);
    }
}
