package Heap.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthsmallest {
    
    //O(n log n) time
    public static int findkthSmallest(int[] array, int k) {
        Arrays.sort(array);
        return array[k-1];
    }


    //Using Max Heap
    //Implementing using priority queue
    // Time Complexity: Building max-heap of k elements + Inserting n-K elements to the heap = O(K) + O((n-K)logK) = O(K + (n-K)logK)
    // Space Complexity: O(1)

    public static int findkthSmallest(int[] array, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        //Step 1 : Insert all the element till k in heap
        for(int i = 0; i < k; i++){
            pq.add(array[i]);
        }

        //Step 2 : If array[i] < p.top then insert and push
        for(int i = k; i <= r; i++){
            if(array[i] < pq.peek()){
                pq.poll();
                pq.add(array[i]);
            }
        }

        return pq.peek();
    }

    //Using min heap
    public static int findkthLargest(int[] array, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < k; i++){
            pq.add(array[i]);
        }

        for(int i = k; i <= r; i++){
            if(array[i] > pq.peek()){
                pq.poll();
                pq.add(array[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] array = {7, 10, 4, 20, 15};
        System.out.println(findkthSmallest(array, 4));

        System.out.println(findkthSmallest(array, 0, 4, 4));
        System.out.println(findkthLargest(array, 0, 4, 4));
    }
}
