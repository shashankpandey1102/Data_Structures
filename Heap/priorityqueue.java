package Heap;

import java.util.Collections;
import java.util.PriorityQueue;


//By default it creates min heap
public class priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.add(4);
        pq.add(2);
        pq.add(5);
        pq.add(3);

        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());


        


        
    }
}
