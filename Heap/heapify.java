package Heap;

//In this we are using index sysyem from 0
public class heapify {
    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    //maxHeapify : Building Max Heap
    //array : input array
    //n : number of elements needs to be processed
    //i : largest index of node at which we need to perform heapify
    //Heapify is done in O(log(n)) time

    public static void maxHeapify(int[] array, int n, int i){
        int largest = i;
        int left = (2 * i) + 1;
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

    public static void doMaxHeapify(int[] array) {
        int n =  array.length;
        
        //applying max heapify at every possible index
        for(int i = n/2-1; i >= 0; i--){
            maxHeapify(array, n, i);
        }

        //printing 
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //min Heapify : Building min Heap

    public static void minHeapify(int[] array, int n, int i) {
        
        int smallest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if(left < n && array[left] < array[smallest]){
            smallest = left;
        }
        if(right < n && array[right] < array[smallest]){
            smallest = right;
        }

        if(smallest != i){
            swap(smallest, i, array);
            minHeapify(array, n, smallest);
        }
    }

    public static void doMinHeapify(int[] array) {
        int n = array.length;

        for(int i = n/2-1; i >= 0; i--){
            minHeapify(array, n, i);
        }

        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] array = {50, 55, 53, 52, 54};
        doMaxHeapify(array);
        doMinHeapify(array);
    }
}
