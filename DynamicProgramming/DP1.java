package DynamicProgramming;

import java.util.Arrays;

public class DP1 {

    public static int fibRec(int n){
        if(n == 0)
        return 0;

        if(n == 1)
        return 1;

        return fibRec(n-1) + fibRec(n-2);
    }
    
    //Bottom-up : In this approach we first evaluate for smaller value and iteratively move to upper value
    //For ex : In fib(5) we first calculate fib(1), fib(2) .... and then move to fib(5)
    //This is always iterative as per my knowledge till date

    public static int fib(int n) {
       int[] f = new int[n+1];

       f[0] = 0;
       f[1] = 1;

       for(int i = 2; i <= n; i++){
        f[i] = f[i-1] + f[i-2];
       }

       System.out.println(Arrays.toString(f));
       return f[n];
    }

    //Top Down Approach : In this approach we start from value at top and then move down
    //For ex: in fib(5) we first evaluate for 5 ant then move down
    //This is always recursive as per my knowledge till date

    int[] check = new int[100];
    void initialize() {
        for(int i = 0; i < check.length; i++){
            check[i] = -1;
        }
    }

    int fib2(int n) {
        if(check[n] == -1){
            if(n <= 1)
            check[n] = n;
            else
            check[n] = fib2(n - 1) + fib2(n - 2);
        }

        return check[n];
    }

    public static void main(String[] args) {
     
        System.out.println(fib(8));
        //System.out.println(fibRec(50));
        
        
        DP1 d = new DP1();
        d.initialize();
        System.out.println(d.fib2(50));
        System.out.println(Arrays.toString(d.check));
        
    }
}
