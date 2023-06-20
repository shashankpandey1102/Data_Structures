package Recursion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RecursionTop9 {

    //O(2^n) time where n is the number of disks
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        
        if(n == 1){
            System.out.println("Transfer Disk " + n + " from " + src + " to " + dest);
            return;
        }
        

        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer Disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }

    //O(n) time where n is the length of string
    public static void printRev(String str, int index) {
        if(index == -1)
        return;
        
        System.out.print(str.charAt(index));
        printRev(str, index-1);
    }

    public static int first = -1;
    public static int last = -1;
    
    //O(n) time where n is the length of String
    public static void findOccurance(String str, int index, char element){
        if(index == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }


        char curr = str.charAt(index);
        if(curr == element){
            if(first == -1){
                first = index;
            }
            else{
                last = index;
            }
        }


        findOccurance(str, index+1, element);
    }

    //O(n) time where n is the length of array
    public static boolean isSorted(int[] array, int index) {
        if(index == array.length-1)
        return true;

        if(array[index] >= array[index+1])
        return false;

        return isSorted(array, index+1);
    }

    public static void moveEnd(String str, char x) {
        
        char[] array = str.toCharArray();
        int start = 0;
        int end = array.length - 1;

        while(start < end){
            if(array[start] != x)
            start++;
            else if(array[end] == x)
            end --;
            else{
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }

        String result = "";
        for(int i = 0; i < array.length; i++){
            result += array[i];
        }

        System.out.println(result);
        
    }

    public static void removeDuplicates(String str) {
        
        HashSet<Character> set = new HashSet<Character>();

        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }

        String newString = "";
        // Iterator<Character> itr = set.iterator();
        // while(itr.hasNext()){
        //     newString += itr.next();
        // }

        for(char ch : set){
            newString += ch;
        }
        System.out.println(newString);
    }

    public static List<String> printSub(String str) {
        List<String> subset = new ArrayList<String>();
        subset.add("");

        char[] input = str.toCharArray();

        for(char ch : input){
            int len = subset.size();

            for(int i = 0; i < len; i++){
                String check = subset.get(i);
                check += ch;
                subset.add(check);
            }
        }

        
        return subset;
    }
    //O(n) time where n is the length of string
    public static void moveAllEnd(String str, int index, int count, String newString, char target) {
        if(index == str.length()){
            for(int i = 0; i < count; i++){
                newString += target;
            }

            System.out.println(newString);
            return;
        }
        
        char ch = str.charAt(index);
        if(ch == target){
            count++;
            moveAllEnd(str, index+1, count, newString, target);
        }
        else{
            newString += ch;
            moveAllEnd(str, index+1, count, newString, target);
        }
    }

    //O(n) time where n is the length of string
    public static boolean[] letter = new boolean[26];   //contains false by default

    public static void removeDuplicates(String str, int index, String newString) {
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
        
        char ch = str.charAt(index);
        if(letter[ch - 'a']){
            removeDuplicates(str, index+1, newString);
        }
        else{
            newString += ch;
            letter[ch - 'a'] = true;
            removeDuplicates(str, index+1, newString);
        }
    }

    //O(2^n) time where n is the length of string
    public static void printSubsequence(String str, int index, String newString) {
        if(index == str.length()){
            System.out.print(newString + " ");
            return;
        }
        
        char ch = str.charAt(index);

        //to be added -> choice 1
        printSubsequence(str, index+1, newString+ch);

        //not to added -> choice 2
        printSubsequence(str, index+1, newString);
    }

    public static void printUniqueSubsequence(String str, int index, String newString, HashSet<String> set) {
        if(index == str.length()){
            if(set.contains(newString))
            return;
            else{
                System.out.print(newString + " ");
                set.add(newString);
                return;
            }
        }
        
        char ch = str.charAt(index);

        //to be added -> choice 1
        printUniqueSubsequence(str, index+1, newString+ch,set);

        //not to added -> choice 2
        printUniqueSubsequence(str, index+1, newString,set);
    }

    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static void printComb(String str, int index, String combination) {
        if(index == str.length()){
            System.out.println(combination);
            return;
        }
        
        char ch = str.charAt(index);
        String mapping = keypad[ch - '0'];

        for(int i = 0; i < mapping.length(); i++){
            printComb(str, index+1, combination+mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        // int n =  2;
        // towerOfHanoi(n, "S", "H", "D");

        // String str =  "abcd";
        // printRev(str, str.length()-1);
        // System.out.println();

        // String str =  "bcdaaagdsafg";
        // findOccurance(str, 0, 'a');      
        
        // int[] array = {1,2,3,4,5};
        // System.out.println(isSorted(array, 0));

        // String str = "axbcxxd";
        // moveEnd(str, 'x');

        // String str = "axbcxxd";
        // moveAllEnd(str, 0, 0, "",'a');

        // String str = "aaabbcccdddaa";
        // removeDuplicates(str,0,"");

        // HashSet<String> set = new HashSet<String>();
        // String str = "aaa";
        // List<String> check = printSub(str);
        // for(String itr : check){
        //     set.add(itr);
        // }
        // for(String i : set){
        //     System.out.print(i + " ");
        // }
        // System.out.println();

        // String str = "abc";
        // printSubsequence(str,0, "");

        // String str= "abc";
        // printUniqueSubsequence(str, 0, "", new HashSet<String>());
        // System.out.println();

        // String str = "14";
        // printComb(str, 0, "");
     }
}
