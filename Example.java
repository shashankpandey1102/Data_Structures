import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Example{

   public static String trimSpaces(String word){
      StringBuilder sb = new StringBuilder();
      int start = 0;
      int end = word.length()-1;

      while(start <= end && word.charAt(start) == ' ')
      start++;

      while(end > 0 && word.charAt(end) == ' ')
      end--;

      for(int i = start; i <= end; i++){
          char ch = word.charAt(i);

          if(ch != ' '){
              sb.append(ch);
          }
          else{
              if(sb.charAt(sb.length()-1) == ' ')
              continue;
              else
              sb.append(' ');
          }
      }

      return sb.toString();
  }
   public static void main(String[] args) {
      String word = trimSpaces("     the    sky      is   blue   ");
      System.out.println(word);
   }
}
