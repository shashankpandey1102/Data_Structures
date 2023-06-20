package DynamicProgramming;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Dynamic {
    
    public static int fibRec(int n) {
        if(n <= 2)
        return 1;

        return fibRec(n-1) + fibRec(n-2);
    }

    public static long fibDynamic(int n, long[] memo) {
        if(memo[n] != 0)
        return memo[n];

        if(n <= 2)
        return 1;
        
        memo[n] = fibDynamic(n-1, memo) + fibDynamic(n-2, memo);

        return memo[n];
    }

////////////////////////////////////////////////////////////////////////////////////////////
//GRID TRAVELER


public static int gridTravellerRec(int m, int n) {
    if(n == 0 || m == 0)
    return 0;

    if(n == 1 && m == 1)
    return 1;

    // down = (m-1, n)
    //right = (m, n-1)
    //total = down + right

    return gridTravellerRec(m-1, n) + gridTravellerRec(m, n-1);
}

public static long gridTravellerDynamic(int m, int n, long[][] memo) {

    if(memo[m][n] != 0 || memo[n][m] != 0)
    return memo[m][n];
 
    if(m == 0 || n == 0)
    return 0;
    
    if(n == 1 && m == 1)
    return 1;

    memo[m][n] = memo[n][m] = gridTravellerDynamic(m-1, n, memo) + gridTravellerDynamic(m, n-1, memo);

    return memo[m][n];
}

//////////////////////////////////////////////////////////////////////////////////////
//  canSum

public static boolean canSum(int targetSum, int[] numbers) {
    if(targetSum == 0) return true;
    if(targetSum < 0) return false;

    for(int num : numbers){
        int remainder = targetSum - num;
        
        if(canSum(remainder, numbers) == true){
            return true;
        }
    }

    return false;
}
public static boolean canSumDynamic(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
    if(memo.containsKey(targetSum)) 
        return memo.get(targetSum);
    
    if(targetSum == 0) 
        return true;
    
    if(targetSum < 0) 
        return false;

    for(int num : numbers){
        int remainder = targetSum - num;
        
        if(canSumDynamic(remainder, numbers, memo) == true){
            memo.put(targetSum, true);
            return true;
        }
    }

    memo.put(targetSum, false);
    return false;
}

////////////////////////////////////////////////////////////////////////////////////////
//howSum

public static ArrayList<Integer> howSum(int targetSum, int[] numbers) {
    if(targetSum == 0)
    return new ArrayList<Integer>();

    if(targetSum < 0)
    return null;

    for(int num : numbers){
        int remainder = targetSum - num;

        if(howSum(remainder, numbers) != null){
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = howSum(remainder, numbers);
            res.add(num);
            return res;
        }
    }

    return null;
}

public static ArrayList<Integer> howSumDynamic(int targetSum, int[] numbers, HashMap<Integer,ArrayList<Integer>> memo) {
    if(memo.containsKey(targetSum))
    return memo.get(targetSum);
    
    if(targetSum == 0)
    return new ArrayList<Integer>();

    if(targetSum < 0)
    return null;

    for(int num : numbers){
        int remainder = targetSum - num;

        if(howSumDynamic(remainder, numbers, memo) != null){
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = howSumDynamic(remainder, numbers, memo);
            res.add(num);
            memo.put(targetSum, res);
            return res;
        }
    }
    memo.put(targetSum, null);
    return null;
}


//////////////////////////////////////////////////////////////////////////////////////
//bestSum


public static ArrayList<Integer> bestSum(int targetSum, int[] numbers) {
    if(targetSum == 0)
    return new ArrayList<Integer>();

    if(targetSum < 0)
    return null;

    ArrayList<Integer> shortestPath = null;

    for(int num : numbers){
        int remainder = targetSum - num;

        ArrayList<Integer> check = bestSum(remainder, numbers);

        if(check != null){
            ArrayList<Integer> combination = new ArrayList<Integer>();
            //combination = bestSum(remainder, numbers);
            combination.add(num);
            combination.addAll(check);

            if(shortestPath == null || combination.size() < shortestPath.size()){
                shortestPath = combination;
            }
        }
    }
    return shortestPath;
}

public static ArrayList<Integer> bestSumDynamic(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> memo) {
    if(memo.containsKey(targetSum))
    return memo.get(targetSum);
    
    if(targetSum == 0)
    return new ArrayList<Integer>();

    if(targetSum < 0)
    return null;

    ArrayList<Integer> shortestPath = null;

    for(int num : numbers){
        int remainder = targetSum - num;

        ArrayList<Integer> check = bestSumDynamic(remainder, numbers, memo);

        if(check != null){
            ArrayList<Integer> combination = new ArrayList<Integer>();
            //combination = bestSum(remainder, numbers);
            combination.add(num);
            combination.addAll(check);

            if(shortestPath == null || combination.size() < shortestPath.size()){
                shortestPath = combination;
            }
        }
    }

    memo.put(targetSum, shortestPath);
    return shortestPath;
}

////////////////////////////////////////////////////////////////////////////////////////////
//canContruct

public static boolean canConstruct(String targetSum, String[] wordbank) {
    if(targetSum.isEmpty())
    return true;

    for(String word : wordbank){
        if(targetSum.startsWith(word)){
            //String suffix = targetSum.replaceAll(word, "");
            String suffix = targetSum.substring(word.length(), targetSum.length());

            if(canConstruct(suffix, wordbank) == true){
                return true;
            }
        }
    }

    return false;
}


public static boolean canConstructDynamic(String targetSum, String[] wordbank, HashMap<String, Boolean> memo) {
    if(memo.containsKey(targetSum))
    return memo.get(targetSum);

    if(targetSum.isEmpty())
    return true;

    for(String word : wordbank){
        if(targetSum.startsWith(word)){
            //String suffix = targetSum.replaceAll(word, "");
            String suffix = targetSum.substring(word.length(), targetSum.length());

            if(canConstructDynamic(suffix, wordbank, memo) == true){
                memo.put(targetSum, true);
                return true;
            }
        }
    }
    memo.put(targetSum, false);
    return false;
}


///////////////////////////////////////////////////////////////////////////////////////
//countConstruct


public static int countConstruct(String target, String[] wordbank) {
    if(target.length()==0)
    return 1;

    int totalCount = 0;

    for(String word : wordbank){
        if(target.startsWith(word)){
            String suffix = target.substring(word.length(), target.length());
            //String suffix = target.replaceAll(word, "");

            int numOfWays = countConstruct(suffix, wordbank);
            totalCount += numOfWays;
        }

    }
    return totalCount;
}

public static int countConstructDynamic(String target, String[] wordbank, HashMap<String, Integer> memo) {
    if(memo.containsKey(target))
    return memo.get(target);

    if(target.length()==0)
    return 1;

    int totalCount = 0;

    for(String word : wordbank){
        if(target.startsWith(word)){
            String suffix = target.substring(word.length(), target.length());
            //String suffix = target.replaceAll(word, "");

            int numOfWays = countConstructDynamic(suffix, wordbank, memo);
            totalCount += numOfWays;
        }

    }

    memo.put(target, totalCount);
    return totalCount;
}



/////////////////////////////////////////////////////////////////////////////////////
//allConstruct

public static List<List<String>> allConstruct(String target, List<String> wordBank) {
    if (target.isEmpty()) {
        return new ArrayList<>(Arrays.asList(new ArrayList<>()));
    }

    List<List<String>> result = new ArrayList<>();

    for (String word : wordBank) {

      if (target.startsWith(word)) {
        String suffix = target.substring(word.length());

        List<List<String>> suffixWays = allConstruct(suffix, wordBank);
        List<List<String>> targetWays = new ArrayList<>();

        for (int i = 0; i < suffixWays.size(); i++) {
          List<String> temp = new ArrayList<>(suffixWays.get(i));
          temp.add(word);
          targetWays.add(temp);
        }

        for (int i = 0; i < targetWays.size(); i++) {
          result.add(new ArrayList<>(targetWays.get(i)));
        }

      }
    }
    return result;
  }

  public static List<List<String>> allConstructDynamic(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {
    if(memo.containsKey(target))
    return memo.get(target);
    
    if (target.isEmpty()) {
        return new ArrayList<>(Arrays.asList(new ArrayList<>()));
    }

    List<List<String>> result = new ArrayList<>();

    for (String word : wordBank) {

      if (target.startsWith(word)) {
        String suffix = target.substring(word.length());

        List<List<String>> suffixWays = allConstructDynamic(suffix, wordBank, memo);
        List<List<String>> targetWays = new ArrayList<>();

        for (int i = 0; i < suffixWays.size(); i++) {
          List<String> temp = new ArrayList<>(suffixWays.get(i));
          temp.add(word);
          targetWays.add(temp);
        }

        for (int i = 0; i < targetWays.size(); i++) {
          result.add(new ArrayList<>(targetWays.get(i)));
        }

      }
    }

    memo.put(target, result);
    return result;
  }


    public static void main(String[] args) {

/*------------------------Fibonacci------------------------------------------- */
    //    System.out.println(fibRec(6));
    //    System.out.println(fibRec(7));
    //    System.out.println(fibRec(8));
    //    System.out.println(fibRec(50));

    // int n = 50;
    // long[] memo = new long[n+1];
    // System.out.println(fibDynamic(n, memo));


/*----------------------Grid Traveller---------------------------------------- */
    // System.out.println(gridTravellerDynamic(18, 18, new long[50][50] ));



/*----------------------canSum------------------------------------------------ */
    // System.out.println(canSum(7, new int[] {2,3}));
    // System.out.println(canSum(7, new int[] {5,3,4,7}));
    // System.out.println(canSum(7, new int[] {2,4,}));
    // System.out.println(canSum(8, new int[] {2,3,5}));
    // System.out.println(canSum(300, new int[] {7,14}));

     //System.out.println(canSumDynamic(7, new int[] {2,3}, new HashMap<Integer, Boolean>()));
    // System.out.println(canSumDynamic(7, new int[] {5,3,4,7}, new HashMap<Integer, Boolean>()));
    // System.out.println(canSumDynamic(7, new int[] {2,4,}, new HashMap<Integer, Boolean>()));
    // System.out.println(canSumDynamic(8, new int[] {2,3,5},new HashMap<Integer, Boolean>()));
    // System.out.println(canSumDynamic(300, new int[] {7,14}, new HashMap<Integer, Boolean>()));



/*-----------------------howSum------------------------------------------------- */
    
    // System.out.println(howSum(7, new int[] {2, 3}));
    // System.out.println(howSum(7, new int[] {5,3,4,7}));
    // System.out.println(howSum(7, new int[] {2,4,}));
    // System.out.println(howSum(8, new int[] {2,3,5}));
    // System.out.println(howSum(300, new int[] {7,14}));


    // System.out.println(howSumDynamic(7, new int[] {2, 3}, new HashMap<>()));
    // System.out.println(howSumDynamic(7, new int[] {5,3,4,7}, new HashMap<>()));
    // System.out.println(howSumDynamic(7, new int[] {2,4,}, new HashMap<>()));
    // System.out.println(howSumDynamic(8, new int[] {2,3,5}, new HashMap<>()));
    // System.out.println(howSumDynamic(300, new int[] {7,14}, new HashMap<>()));



/*--------------------------------bestSum---------------------------------------- */

    // System.out.println(bestSum(7, new int[] {5, 3, 4, 7}));
    // System.out.println(bestSum(8, new int[] {2,3,5}));
    // System.out.println(bestSum(8, new int[] {1,4,5}));
    // System.out.println(bestSum(100, new int[] {1,2,5,25}));


    // System.out.println(bestSumDynamic(7, new int[] {5, 3, 4, 7}, new HashMap<>()));
    // System.out.println(bestSumDynamic(8, new int[] {2,3,5,}, new HashMap<>()));
    // System.out.println(bestSumDynamic(8, new int[] {1,4,5}, new HashMap<>()));
    // System.out.println(bestSumDynamic(100, new int[] {1,2,5,25}, new HashMap<>()));


/*------------------------------ canContruct----------------------------------------*/

// System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
// System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
// System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
// System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
// new String[]{"e", 
//             "ee", 
//             "eee", 
//             "eeee", 
//             "eeeee", 
//             "eeeeee"}));



// System.out.println(canConstructDynamic("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
// System.out.println(canConstructDynamic("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
// System.out.println(canConstructDynamic("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
// System.out.println(canConstructDynamic("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
//              new String[]{"e", 
//                          "ee", 
//                          "eee", 
//                          "eeee", 
//                          "eeeee", 
//                          "eeeeee"}, new HashMap<>()));

            

/*------------------------------countConstruct------------------------------------- */


        // System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}));
        // System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        // System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        // System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
        // new String[]{"e", 
        //             "ee", 
        //             "eee", 
        //             "eeee", 
        //             "eeeee", 
        //             "eeeeee"}));



        // System.out.println(countConstructDynamic("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}, new HashMap<>()));
        // System.out.println(countConstructDynamic("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        // System.out.println(countConstructDynamic("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        // System.out.println(countConstructDynamic("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
        // new String[]{"e", 
        //             "ee", 
        //             "eee", 
        //             "eeee", 
        //             "eeeee", 
        //             "eeeeee"}, new HashMap<>()));



/*----------------------------------allConstruct------------------------------------ */

            // ArrayList<String> abcd = new ArrayList<String>(Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef"));
            // ArrayList<String> skateboard = new ArrayList<String>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"));
            // ArrayList<String> enterapotentpot = new ArrayList<String>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"));
            // ArrayList<String> ooef = new ArrayList<String>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee"));
            
            // System.out.println(allConstruct("abcdef", abcd));
            // System.out.println(allConstruct("skateboard", skateboard));
            // System.out.println(allConstruct("enterapotentpot", enterapotentpot));
            // System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ooef));


            // System.out.println(allConstructDynamic("abcdef", abcd, new HashMap<>()));
            // System.out.println(allConstructDynamic("skateboard", skateboard, new HashMap<>()));
            // System.out.println(allConstructDynamic("enterapotentpot", enterapotentpot, new HashMap<>()));
            // System.out.println(allConstructDynamic("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ooef, new HashMap<>()));

    }
}
