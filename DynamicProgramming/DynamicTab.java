package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DynamicTab {

/////////////////////////////////////////////////////////////////////////////////////////
//fibTabulation


    public static long fibTabulation(int n) {
        long[] fib = new long[n+1];
        fib[1] = 1;

        //i=0 to n
        //fib[i+1] += fib[i]
        //fib[i+2] += fib[i]

        for(int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }


//////////////////////////////////////////////////////////////////////////////////////////
//Grid Traveller

public static long gridTravellerTabuation(int m, int n) {

    long[][] table = new long[m+1][n+1];
    table[1][1] = 1;

    //System.out.println(Arrays.deepToString(table));

    for(int i = 0; i <= m; i++){
        for(int j = 0; j <= n; j++){
            Long current = table[i][j];

            if(j+1 <= n) table[i][j+1] += current;
            
            if(i+1 <= m) table[i+1][j] += current;
        }
    }

    return table[m][n];
}


///////////////////////////////////////////////////////////////////////////////////////
//canSum

public static boolean canSumTabulation(int targetSum, int[] numbers) {
    
    boolean[] table = new boolean[targetSum+1];
    table[0] = true;

    for(int i = 0; i <= targetSum; i++){
        if(table[i] == true){
            for(int num : numbers){

                if(i+num <= targetSum) table[i+num] = true;
            }
        }
    }

    return table[targetSum];
}

///////////////////////////////////////////////////////////////////////////////////////
//howSum

public static List<Integer> howSumTabulation(int targetSum, int[] numbers) {
    List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum+1, null));
    table.set(0, new ArrayList<>());

    for(int i = 0; i < targetSum; i++){
        if(table.get(i) != null){
            for(int num : numbers){
                if(i+num <= targetSum){
                    table.set(i+num, new ArrayList<>(table.get(i)));
                    table.get(i+num).add(num);
                }
            }
        }
    }

    return table.get(targetSum);
}



////////////////////////////////////////////////////////////////////////////////////
//bestSum

public static List<Integer> bestSumTabulation(int targetSum, int[] numbers) {
    List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
    table.set(0, new ArrayList<>());

    for(int i = 0; i <= targetSum; i++){
        if(table.get(i) != null){
            for(int num : numbers){
                if(i + num <= targetSum){
                
                List<Integer> combination = new ArrayList<>();
                combination.addAll(table.get(i));
                combination.add(num);

                if(table.get(i+num) == null || combination.size() < table.get(i+num).size())
                table.set(i+num, combination);

                }
            }
        }
    }

    return table.get(targetSum);
}

////////////////////////////////////////////////////////////////////////////////////////
//canConstruct

//time : O(m^2*n) and space : O(m)
public static boolean canConstructTabulation(String target, String[] wordbank) {
    boolean[] table = new boolean[target.length() + 1];
    table[0] = true;

    for(int i = 0; i <= target.length(); i++){
        if(table[i]){
            for(String word : wordbank){

                //Imp Logic
                if(target.substring(i).startsWith(word)){
                    table[i+word.length()] = true; 
                }
            }
        }
    }
    return table[target.length()];
}



///////////////////////////////////////////////////////////////////////////////////////
//countConstruct
//time : O(m^2*n) and space : O(m)
public static int countConstructTabulation(String target, String[] wordbank) {
    int[] table = new int[target.length() + 1];
    table[0] = 1;

    for(int i = 0; i <= target.length(); i++){
        if(table[i] != 0){
            for(String word : wordbank){
                if(target.substring(i).startsWith(word)){
                    table[i + word.length()] += table[i];
                }
            }
        }
    }

    return table[target.length()];
}



////////////////////////////////////////////////////////////////////////////////////////
//allConstruct
//time : O(n^m) and space O(n^m)

public static List<List<String>>  allConstructTabulation(String target, String[] wordbank) {
    List<List<List<String>>> table = new ArrayList<>(Collections.nCopies(target.length() + 1, null));
    for(int i = 0; i <= target.length(); i++){
        table.set(i, new ArrayList<>());
    }

    table.get(0).add(new ArrayList<>());

    for(int i = 0; i <= target.length(); i++){
        for(String word : wordbank){
            if(target.substring(i).startsWith(word)){
                List<List<String>> combination = new ArrayList<>();

                for(List<String> subArray : table.get(i)){
                    List<String> subArrayTemp = new ArrayList<>(subArray);
                    subArrayTemp.add(word);
                    combination.add(subArrayTemp);
                }
                
                for(List<String> subArray : combination){
                    table.get(i+word.length()).add(new ArrayList<>(subArray));
                }
            }
        }
    }

    return table.get(target.length());
}


    public static void main(String[] args) {

/*-----------------------------------Fib Tabulation----------------------------------- */

        // System.out.println(fibTabulation(6));
        // System.out.println(fibTabulation(7));
        // System.out.println(fibTabulation(8));
        // System.out.println(fibTabulation(50));



/*-----------------------------------Grid Traveller----------------------------------- */

    // System.out.println(gridTravellerTabuation(1, 1));    
    // System.out.println(gridTravellerTabuation(2, 3));
    // System.out.println(gridTravellerTabuation(3, 2));
    // System.out.println(gridTravellerTabuation(3, 3));
    // System.out.println(gridTravellerTabuation(18, 18));



/*----------------------------------canSum--------------------------------------------*/

// System.out.println(canSumTabulation(7, new int[] {2, 3}));
// System.out.println(canSumTabulation(7, new int[] {5, 3, 4, 7}));
// System.out.println(canSumTabulation(7, new int[] {2, 4}));
// System.out.println(canSumTabulation(8, new int[] {2, 3, 5}));
// System.out.println(canSumTabulation(300, new int[] {7, 14}));


/*----------------------------------howSum------------------------------------------- */

// System.out.println(howSumTabulation(7, new int[] {2, 3}));
// System.out.println(howSumTabulation(7, new int[] {5, 3, 4, 7}));
// System.out.println(howSumTabulation(7, new int[] {2, 4}));
// System.out.println(howSumTabulation(8, new int[] {2, 3, 5}));
// System.out.println(howSumTabulation(300, new int[] {7, 14}));



/*-----------------------------------bestSum---------------------------------------- */


// System.out.println(bestSumTabulation(7, new int[] {5, 3, 4, 7}));
// System.out.println(bestSumTabulation(8, new int[] {2, 3, 5}));
// System.out.println(bestSumTabulation(8, new int[] {1, 4, 5}));
// System.out.println(bestSumTabulation(100, new int[] {1, 2, 5, 25}));



/*----------------------------------canConstruct------------------------------------ */


// System.out.println(canConstructTabulation("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
// System.out.println(canConstructTabulation("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
// System.out.println(canConstructTabulation("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
// System.out.println(canConstructTabulation("ooooooooooooooooooooooooooooooooooooooooooof", 
//                 new String[] {"o", "oo", "ooo", "oooo", "ooooo", "oooooo"}));



/*-----------------------------------countConstruct--------------------------------- */

// System.out.println(countConstructTabulation("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
// System.out.println(countConstructTabulation("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
// System.out.println(countConstructTabulation("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
// System.out.println(countConstructTabulation("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
// System.out.println(countConstructTabulation("ooooooooooooooooooooooooooooooooooooooooooof", 
//                 new String[] {"o", "oo", "ooo", "oooo", "ooooo", "oooooo"}));




/*------------------------------------allConstruct----------------------------------- */

System.out.println(allConstructTabulation("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
System.out.println(allConstructTabulation("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
System.out.println(allConstructTabulation("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
System.out.println(allConstructTabulation("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
System.out.println(allConstructTabulation("ooooooooooooooooooooooooooooooooooooooooooof", 
                new String[] {"o", "oo", "ooo", "oooo", "ooooo", "oooooo"}));




    }
}
