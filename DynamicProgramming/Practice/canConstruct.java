package DynamicProgramming.Practice;

import java.util.ArrayList;
import java.util.HashMap;

public class canConstruct {

    //O(n^m * m) time and O(m^2) space
    public static boolean canConstructRec(String target, String[] wordbank) {
        if(target.isEmpty())
        return true;

        for(String word : wordbank){
            if(target.startsWith(word)){
                String remainder = target.substring(word.length());
                if(canConstructRec(remainder, wordbank)){
                    return true;
                }
            }
        }

        return false;
    }

    //O(m^2 * n) time and O(m^2) space 
    public static boolean canConstructMemo(String target, String[] wordbank, HashMap<String, Boolean> memo) {
        if(memo.containsKey(target))
        return memo.get(target);
        
        if(target.isEmpty())
        return true;

        for(String word : wordbank){
            if(target.startsWith(word)){
                String remainder = target.substring(word.length());
                if(canConstructMemo(remainder, wordbank, memo)){
                    memo.put(target, true);
                    return true;
                }
            }
        }
        
        memo.put(target, false);
        return false;
    }
    

    //O(m^2*n) time and O(m) space
    public static boolean canConstructTabulation(String target, String[] wordbank) {
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for(int i = 0; i <= target.length(); i++){
            if(table[i]){
                for(String word : wordbank){
                    
                    
                    if(target.substring(i).startsWith(word)){
                        table[i+word.length()] = true;
                    }

                }
            }
        }

        return table[target.length()];
    }
   
    public static void main(String[] args) {
// System.out.println(canConstructRec("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
// System.out.println(canConstructRec("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));


// System.out.println(canConstructMemo("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
// System.out.println(canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
// new String[]{"e", 
//             "ee", 
//             "eee", 
//             "eeee", 
//             "eeeee", 
//             "eeeeee"},new HashMap<>()));




System.out.println(canConstructTabulation("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
System.out.println(canConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
new String[]{"e", 
            "ee", 
            "eee", 
            "eeee", 
            "eeeee", 
            "eeeeee"}));


    }
}
