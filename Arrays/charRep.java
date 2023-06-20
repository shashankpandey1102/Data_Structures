package Arrays;

import java.util.Collections;
import java.util.HashMap;

public class charRep {
    
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxFreq = Collections.max(map.values());

            if(right - left + 1 - maxFreq > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        
        while(right < s2.length()){
            if(!map.containsKey(s2.charAt(right))){
                left++;
                right++;
            }
            else{
                map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
                left++;
            }
        }
        
        if(s1.length() == right - left + 1)
            return true;
        
        
        return false;
    }

    public static HashMap<Character, Integer> fillMap(int start, int end, String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = start; i < end; i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        
        return map;
    }

    public static void main(String[] args) {
        int res = characterReplacement("ABABBA", 2);
        System.out.println(res);

        HashMap<Character, Integer> result = fillMap(0, 2, "ab");
        HashMap<Character, Integer> result2 = fillMap(0, 2, "ab");
        if(result.equals(result2))
        System.out.println(result);
    }
}
