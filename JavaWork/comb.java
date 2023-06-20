package JavaWork;

import java.util.Arrays;

class pair implements Comparable<pair>{
    
    String x;
    int y;

    public pair(String x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(" + x + " " + y + ")";
    }

    @Override
    public int compareTo(pair p) {
        // TODO Auto-generated method stub
        if(this.x.compareTo(p.x) != 0){
            return this.x.compareTo(p.x);
        }
        else{
            return this.y - p.y;
        }
    }
}

public class comb {
    public static void main(String[] args) {

        int n = 4;
        pair arr[] = new pair[n];
 
        arr[0] = new pair("abc", 3);
        arr[1] = new pair("a", 4);
        arr[2] = new pair("bc", 5);
        arr[3] = new pair("a", 2);
 
        // Sorting the array
        Arrays.sort(arr);
 
        // printing the
        // Pair array
        print(arr);
        
    }

    public static void print(pair[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); 
        }
    }
}
