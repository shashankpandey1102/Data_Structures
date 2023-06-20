package Recursion;
public class Recursion1 {
    
    public static void print(int n) {
        if(n==0)
        return;
        System.out.println(n);
        print(n-1);
    }

    public static void print2(int n) {
        if(n>5)
        return;
        
        System.out.println(n);
        print2(n+1);
    }

    public static void printSum(int i, int n, int sum) {
        if(i==n){
            sum += i;
            System.out.println(sum);
            return;
        }

        sum += i;
        printSum(i+1, n, sum);
        System.out.println(i);
    }
    
    public static void factorial(int n, int result) {
        if(n==1){
            result *=n;
            System.out.println(result);
            return;
        }

        result*= n;
        factorial(n-1, result);
    }

    public static int calcFactorial(int n) {
        if(n==1 || n==0)
        return 1;

        int nm1 = calcFactorial(n-1);
        n *= nm1;
        return n;
    }

    public static void printFib(int a, int b, int n) {
        if(n==0)
        return;

        int c = a + b;
        System.out.println(c);
        printFib(b, c, n-1);
    }

    public static void printFibItr(int n) {
        int a=0, b=1;
        System.out.println(a);
        System.out.println(b);

        for(int i = 2; i<n; i++){
            int c = a + b;
            System.out.println(c);
            a=b;
            b=c;
        }
        
    }

    public static void printNthFibItr(int n) {
        int a=0, b=1;
        int res = 0;
        

        for(int i = 2; i<n; i++){
            res = a + b;
            a=b;
            b=res;
        }
        
        System.out.println(res);
    }

    public static int printXRaiseToN(int x, int n){

        if(n==0)
        return 1;

        if(x==0)
        return 0;

       int calc = printXRaiseToN(x, n-1);
       int calc1 = x * calc;
        return calc1;
    }
    public static void main(String[] args) {
        //print(5);

        //print2(1);
        
        //printSum(1, 5, 0);
        
        //factorial(5,1);
        
        // int ans = calcFactorial(5);
        // System.out.println(ans);

        //  int n = 7;
        //  System.out.println(0);
        //  System.out.println(1);
        //  printFib(0, 1, n-2);

        //printFibItr(7);
        
        //printNthFibItr(6);

        // int ans = printXRaiseToN(1, 8);
        // System.out.println(ans);
    }
}
