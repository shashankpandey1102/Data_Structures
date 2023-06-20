package String;

import java.util.HashMap;


public class minWin {
    
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        String sub = "";
        int matched = 0;
        int minLen = Integer.MAX_VALUE;

        for(int end = 0; end < s.length(); end++){
            char right = s.charAt(end);

            if(map.containsKey(right)){
                map.put(right, map.get(right) - 1);
                if(map.get(right) == 0)
                matched++;
            }

            while(matched == map.size()){
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;
                    sub = s.substring(start, end + 1);
                }
                char deleted = s.charAt(start++);
                if(map.containsKey(deleted)){
                    if(map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        String res = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
