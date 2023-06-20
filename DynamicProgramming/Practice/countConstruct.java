package DynamicProgramming.Practice;

import java.util.HashMap;

public class countConstruct {
    
    //O(n^m * m) time and O(m^2)space
    public static int countConstructRec(String target, String[] wordbank) {
        if(target.length() == 0)
        return 1;

        int totalCount = 0;

        for(String word : wordbank){
            
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());

                int numOfWays = countConstructRec(suffix, wordbank);

                totalCount += numOfWays;
            }
        }

        return totalCount;
    }

    //O(m^2 * n) time and O(m^2) space
    public static int countConstructMemo(String target, String[] wordbank, HashMap<String, Integer> memo) {
        if(memo.containsKey(target))
        return memo.get(target);

        if(target.length() == 0)
        return 1;

        int totalCount = 0;

        for(String word : wordbank){
            
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());

                int numOfWays = countConstructMemo(suffix, wordbank, memo);

                totalCount += numOfWays;
            }
        }

        memo.put(target, totalCount);
        return totalCount;
    }


    //O(m^2 * n) time and O(m) space
    public static int countConstructTabulation(String target, String[] wordbank) {
        int[] table = new int[target.length() + 1];
        table[0] = 1;

        for(int i = 0; i <= target.length(); i++){
            if(table[i] != 0){
                for(String word : wordbank){
                    
                    if(target.substring(i).startsWith(word))
                    table[i+word.length()] += table[i];
                }
            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        // System.out.println(countConstructRec("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef"}));
        // System.out.println(countConstructRec("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        // System.out.println(countConstructRec("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        // System.out.println(countConstructRec("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
        // new String[]{"e", 
        //             "ee", 
        //             "eee", 
        //             "eeee", 
        //             "eeeee", 
        //             "eeeeee"}));

    

        System.out.println(countConstructMemo("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef"}, new HashMap<>()));
        System.out.println(countConstructMemo("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(countConstructMemo("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
                    new String[]{"e", 
                                "ee", 
                                "eee", 
                                "eeee", 
                                "eeeee", 
                                "eeeeee"}, new HashMap<>()));


        System.out.println(countConstructTabulation("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd", "ef"}));
        System.out.println(countConstructTabulation("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstructTabulation("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(countConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
                        new String[]{"e", 
                                    "ee", 
                                    "eee", 
                                    "eeee", 
                                    "eeeee", 
                                    "eeeeee"}));
    }
}
