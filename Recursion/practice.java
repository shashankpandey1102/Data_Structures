package Recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;


public class practice {

   public static void findSubset(int n, ArrayList<Integer> subset) {
    if(n==0){
        System.out.println(subset);
        return;
    }
    
    //add hoga
    subset.add(n);
    findSubset(n-1, subset);

    //add nhi hoga
    subset.remove(subset.size()-1);
    findSubset(n-1, subset);
   }

    public static void main(String[] args) {
      findSubset(3, new ArrayList<Integer>());
    }
}

