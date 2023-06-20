package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class practice2 {

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        int i = 0;
        while(s.length() > 0 && s.charAt(i) == ')'){
            i++;
        }

        while(i < s.length()){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'&& !stack.isEmpty()){
                if(stack.pop() == '('){
                    count += 2;
                }
            }
            i++;
        }

        return count;
    }
    public static void main(String[] args) {
        int res = longestValidParentheses("(())");
        System.out.println(res);
    }
}
