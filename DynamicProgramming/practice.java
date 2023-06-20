package DynamicProgramming;
import java.util.*;


public class practice {
    public static int fib(int n) {
        return fib(n, new ArrayList<Integer>());
    }
    
    public static int fib(Integer n, List<Integer> memo){
        if(n == 0){
            //memo.add(n, 0);
            return 0;
        }
        
        if(n == 1){
            //memo.add(n, 1);
            return 0;
        }
        
        memo.add(n, fib(n-1) + fib(n-2));
        return memo.get(n);
    }
    public static void main(String[] args) {
        // int res = fib(5, new ArrayList<>());
        // System.out.println(res);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0, 5);
        if(arr.contains(5))
        System.out.println("yes");
        char ch = 'a';
        char ch2 = 'b';

        int c = (int)ch + 2;
        char word = (char)c;

       System.out.println(word);

       String w = "12";
    }
}
