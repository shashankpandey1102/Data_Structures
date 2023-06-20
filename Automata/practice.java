package Automata;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class practice {

    public static int name(int n) {
        int sum = 0;
        for(int i = 1; i<=n; i++){
            int j = n/i;
            int product = i*j;
            sum += product;
        }
        return sum;
    }

    public static int countGreaterthanK(int[] arr, int k) {
        int count = 0;
        for(int i = 0; i< arr.length; i++){
            int check = 0;
            while(arr[i] > 0){
                arr[i] /= 10;
                check++;
            }
            if(check == k)
            count++;

        }

        return count;
    }

    public static int countWhoseDigitendWithK(int start, int end, int k) {
        int count = 0;

        for(int i = start; i<=end;i++){
            if(i%10 == k)
            count++;
        }
        return count;
    }

    public static int singleDigitSum(int n) {
        int sum = 0;

        while(sum > 9 || n > 0){
            if(n == 0){
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int countLetterorDigit(String str) {
        int count = 0;

        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isLetterOrDigit(ch))
            count++;
        }
        return count;
    }

    public static int countFrequency(int[] arr) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()%2 != 0)
            count += entry.getKey();
        }

        return count;
    }
    
    public static void main(String[] args) {
        // int total = name(5);
        // System.out.println(total);

        //int[] newArr = {10, 22, 3, 4, 1, 6, 7, 8, 5, 33, 4, 99, 100};
        // int count = countGreaterthanK(newArr, 1);
        // System.out.println(count);

        // int count = countWhoseDigitendWithK(10, 54, 2);
        // System.out.println(count);

        // int sum = singleDigitSum(1234);
        // System.out.println(sum);

        // String abc = "Hello World!123";
        // int count = countLetterorDigit(abc);
        // System.out.println(count);

        // int[] arr = {1,1,2,2,2,3,4,4,5,5,5,5,6,7,7};
        // int count = countFrequency(arr);
        // System.out.println(count);
        
        String a = "shashank";
        String b = a.substring(0,2);
        System.out.println(b);
        
    }
}
