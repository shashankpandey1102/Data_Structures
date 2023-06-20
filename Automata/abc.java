package Automata;

import java.util.Arrays;
import java.util.PriorityQueue;

public class abc {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<3;i++){
            pq.add(i);
            pq.add(1);
        }
        pq.remove();
        pq.remove();
        pq.remove();
        
        
        System.out.println(pq);
    }
}
