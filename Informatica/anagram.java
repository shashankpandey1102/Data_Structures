package Informatica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class anagram {
    public static void main(String[] args) throws Exception{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        String target = "";
        StringBuilder sb = new StringBuilder();

        while(!s.equals("null")){
            s = b.readLine();
            if(!s.equals("null")){
                sb.append(s);
                sb.append(",");
            }
        }

        System.out.println(sb.toString());

        }
}
