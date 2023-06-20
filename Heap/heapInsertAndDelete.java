package Heap;

//In this we are using index system from 1
public class heapInsertAndDelete {

    public static int[] array = new int[100];
    public static int size;

    heapInsertAndDelete(){
        size = 0;
    }

    //Creating max heap
    //time complexity : O(log n)
    public static void insertMax(int value) {

        //Step 1 : Insert at the end
        size = size + 1;
        int index = size;
        array[index] = value;

        //Step 2 : Take it to correct position
        while(index > 1){
            int parent = index / 2;

            if(array[index] > array[parent]){
                swap(index, parent, array);
                index = parent;
            }
            else{
                return;
            }
        }
    }

    //Creating min heap
    public static void insertMin(int value) {
        
        size = size + 1;
        int index = size;
        array[index] = value;

        while(index > 1){
            int parent = index / 2;

            if(array[index] < array[parent]){
                swap(index, parent, array);
                index = parent;
            }
            else{
                return;
            }
        }
    }

    //O(log n) time
    //deleting from max heap
    public static void deleteFromHeap() {
        if(size == 0){
            System.out.println("Heap is Empty");
            return;
        }

        //Step 1: swapping last element with root element
        array[1] = array[size];

        //Step 2 : Deleting last element
        size--;

        //Step 3 : Taking node at correct position
        int i = 1;
        while(i < size){
            int left = 2 * i;
            int right = (2 * i) + 1;

            if(left < size && array[left] > array[i]){
                swap(left, i, array);
                i = left;
            }
            else if(right < size && array[right] > array[i]){
                swap(right, i, array);
                i = right;
            }
            else{
                return;
            }
        }

    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {
        for(int i = 1; i <= size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertMax(50);
        insertMax(55);
        insertMax(53);
        insertMax(52);
        insertMax(54);
        print(array);
        deleteFromHeap();
        print(array);

        // insertMin(50);
        // insertMin(55);
        // insertMin(53);
        // insertMin(52);
        // insertMin(54);
        // print(array);
    }
}
