package DynamicProgramming.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class allConstruct {

    //O(n^m) time and O(m) space
    public static List<List<String>> allConstructRec(String target, List<String> wordbank) {
        if(target.isEmpty()){
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        }

        List<List<String>> result = new ArrayList<>();

        for(String word : wordbank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());

                List<List<String>> suffixWays = allConstructRec(suffix, wordbank);
                List<List<String>> targetWays = new ArrayList<>();

                for(int i = 0; i < suffixWays.size(); i++){
                    List<String> temp = new ArrayList<>(suffixWays.get(i));
                    temp.add(word);
                    targetWays.add(temp);
                }

                for(int i = 0; i < targetWays.size(); i++){
                    result.add(new ArrayList<>(targetWays.get(i)));
                }
            }
        }

        return result;
    }

    //O(n^m) time and O(m) space
    public static List<List<String>> allConstructMemo(String target, List<String> wordbank, HashMap<String, List<List<String>>> memo) {
        if(memo.containsKey(target))
        return memo.get(target);
        
        if(target.isEmpty()){
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        }

        List<List<String>> result = new ArrayList<>();

        for(String word : wordbank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());

                List<List<String>> suffixWays = allConstructMemo(suffix, wordbank, memo);
                List<List<String>> targetWays = new ArrayList<>();

                for(int i = 0; i < suffixWays.size(); i++){
                    List<String> temp = new ArrayList<>(suffixWays.get(i));
                    temp.add(word);
                    targetWays.add(temp);
                }

                for(int i = 0; i < targetWays.size(); i++){
                    result.add(new ArrayList<>(targetWays.get(i)));
                }
            }
        }

        memo.put(target, result);
        return result;
    }

    private static List<List<String>> allConstructTabulation(String target, String[] wordbank) {
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

    ArrayList<String> abcd = new ArrayList<String>(Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef"));
    ArrayList<String> skateboard = new ArrayList<String>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"));
    ArrayList<String> enterapotentpot = new ArrayList<String>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"));
    ArrayList<String> ooef = new ArrayList<String>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee"));


    // System.out.println(allConstructRec("abcdef", abcd));
    // System.out.println(allConstructRec("skateboard", skateboard));
    // System.out.println(allConstructRec("enterapotentpot", enterapotentpot));
    // System.out.println(allConstructRec("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ooef));


    // System.out.println(allConstructMemo("abcdef", abcd, new HashMap<>()));
    // System.out.println(allConstructMemo("skateboard", skateboard, new HashMap<>()));
    // System.out.println(allConstructMemo("enterapotentpot", enterapotentpot, new HashMap<>()));
    // System.out.println(allConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ooef, new HashMap<>()));

System.out.println(allConstructTabulation("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
System.out.println(allConstructTabulation("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
System.out.println(allConstructTabulation("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
System.out.println(allConstructTabulation("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}));
System.out.println(allConstructTabulation("ooooooooooooooooooooooooooooooooooooooooooof", 
                 new String[] {"o", "oo", "ooo", "oooo", "ooooo", "oooooo"}));

        
    }
}
