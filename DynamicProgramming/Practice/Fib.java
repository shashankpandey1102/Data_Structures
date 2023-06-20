package DynamicProgramming.Practice;

public class Fib {

//O(2^n) time and O(n) space
public static int fibRec(int n) {
    if(n <= 2)
    return 1;

    return fibRec(n-1) + fibRec(n-2);
}

//O(n) time and O(n) space
public static long fibMemo(int n, long[] memo) {
    if(memo[n] != 0)
    return memo[n];

    if(n <= 2){
        memo[n] = 1;
        return 1;
    }

    memo[n] = fibMemo(n-1, memo) + fibMemo(n-2, memo);
    return memo[n];
}


//O(n) time and O(n) space
public static long fibTabulation(int n) {
    long [] table = new long[n+1];
    table[0] = 0;
    table[1] = 1;

    for(int i = 2; i <= n; i++){
        table[i] = table[i-1] + table[i-2];
    }

    return table[n];
 }

public static void main(String[] args) {
    //System.out.println(fibRec(5));
    //System.out.println(fibMemo(50, new long[100]));
    System.out.println(fibTabulation(50));
}
}
