package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class prac2 {
    public static void main(String[] args) {
      HashSet<List<Integer>> set = new HashSet<>();
      set.add(new ArrayList<>(Arrays.asList(1, 2)));


      boolean check = set.contains(new ArrayList<>(Arrays.asList(1, 2)));
      System.out.println(check);
    }
}