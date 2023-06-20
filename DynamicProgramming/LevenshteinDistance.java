package DynamicProgramming;

import java.util.Arrays;

public class LevenshteinDistance {

    static int maximum = 1000;

    public static int min(int x, int y, int z) {
        int min = Math.min(x, Math.min(y, z));

        return min;
    }
    
    public static int minEditDistance(String s1, String s2, int m, int n) {
        if(m == 0)
        return n;

        if(n == 0)
        return m;

        if(s1.charAt(m-1) == s2.charAt(n-1))
        return minEditDistance(s1, s2, m-1, n-1);

        int insert = minEditDistance(s1, s2, m, n-1);
        int delete = minEditDistance(s1, s2, m-1, n);
        int replace = minEditDistance(s1, s2, m-1, n-1);

        return 1 + min(insert, delete, replace);
    }

    public static int minEditDistanceMemo(String s1, String s2, int m, int n, int[][] memo) {
        if(m == 0)
        return n;

        if(n == 0)
        return m;

        if(memo[m-1][n-1] != -1)
        return memo[m-1][n-1];

        if(s1.charAt(m-1) == s2.charAt(n-1))
        return memo[m-1][n-1] = minEditDistanceMemo(s1, s2, m-1, n-1,memo);

        int insert = minEditDistanceMemo(s1, s2, m, n-1, memo);
        int delete = minEditDistanceMemo(s1, s2, m-1, n, memo);
        int replace = minEditDistanceMemo(s1, s2, m-1, n-1, memo);

        return memo[m-1][n-1] = 1 + min(insert, delete, replace);
    }

    public static int levenshteinDistanceRec(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return minEditDistance(s1, s2, m, n);
    }

    public static int levenshteinDistanceMemo(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] memo = new int[m][maximum];
        for(int i = 0; i < memo.length; i++)
        Arrays.fill(memo[i], -1);

        return minEditDistanceMemo(s1, s2, m, n, memo);
    }

    public static int levenshteinDistanceTabulation(String s1, String s2) {
        //Anuj Bhaeia ke video se
        int m = s1.length();
        int n = s2.length();

        int[][] table = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) table[i][0] = i;
        for(int j = 0; j <= n; j++) table[0][j] = j;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                
                //If characters match then replace with diagonally opposite
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    table[i][j] = table[i-1][j-1];
                }
                else{//If characters dont match
                    table[i][j] = 1 + 
                        Math.min(table[i-1][j-1], Math.min(table[i-1][j], table[i][j-1]));
                }
            }
        }

        return table[m][n];
    }
    
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int m = s1.length();
        int n = s2.length();
        
        int[][] memo = new int[m][maximum];
        for(int i = 0; i < memo.length; i++)
        Arrays.fill(memo[i], -1);

        System.out.println(minEditDistanceMemo(s1, s2, m, n, memo));

        System.out.println(minEditDistance(s1, s2, m, n));

        System.out.println(levenshteinDistanceRec(s1, s2));
        System.out.println(levenshteinDistanceMemo(s1, s2));
        System.out.println(levenshteinDistanceTabulation(s1, s2));
    }
}
