package Recursion;
import java.util.ArrayList;

public class RecursionAdvance {

    //O(n!) time where n is the length of the input string
    public static void printPerm(String str, String permutation) {
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            printPerm(newString, permutation+curr);
        }
    }

    public static int countPath(int i, int j, int m, int n) {
        if( m == 0 || n == 0)
        return 0;

        if(i == m-1 || j == n-1)
        return 1;
        
        // //move right
        // int right = countPath(i, j+1, n, m);

        // //move down
        // int down = countPath(i+1, j, n, m);

        // return right + down;

        return countPath(i+1, j, m, n) + countPath(i, j+1, m, n);
    }

    public static int placeTiles(int n, int m) {
        if(n == m)
        return 2;

        if(n < m)
        return 1;
        
        //place vertically
        int vertical = placeTiles(n-m, m);

        //place horizontally
        int horizontal = placeTiles(n-1, m);

        return vertical+horizontal;
    }

    public static int callGuests(int n) {
        if(n <= 1)
        return 1;
        
        //Single
        int ways1 = callGuests(n-1);

        //Pair
        int ways2 = (n-1) * callGuests(n-2);

        return ways1 + ways2;
    }

    public static void printSubset(ArrayList<Integer> list) {
        
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void findSubset(int n, ArrayList<Integer> subset) {
        if(n == 0){
            printSubset(subset);
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
        String str = "abc";
        printPerm(str, "");

        // int n = 4, m = 5;
        // int totalPath = countPath(0, 0, n, m);
        // System.out.println(totalPath);

        // int n = 1, m = 2;
        // System.out.println(placeTiles(n, m));

        // int n = 4;
        // System.out.println(callGuests(n));

        // int n = 2;
        // ArrayList<Integer> list = new ArrayList<Integer>();
        // findSubset(n, list);
    }
}
