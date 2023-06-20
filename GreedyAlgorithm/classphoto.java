package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class classphoto {
    
    public boolean classPhoto(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeight) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeight, Collections.reverseOrder());
        
        String shirtInFirstRow;
        if(redShirtHeights.get(0) > blueShirtHeight.get(0)){
            shirtInFirstRow = "RED";
        }
        else{
            shirtInFirstRow = "BLUE";
        }

        for(int i = 0; i < redShirtHeights.size(); i++){
            int redHeight = redShirtHeights.get(i);
            int blueHeight = blueShirtHeight.get(i);

            if(shirtInFirstRow == "RED"){
                if(blueHeight >= redHeight)
                return false;
            }
            else{
                if(redHeight >= blueHeight)
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        classphoto obj = new classphoto();
        boolean result = obj.classPhoto(new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4)), new ArrayList<Integer>(Arrays.asList(6, 8, 2, 4, 5)));
        System.out.println(result);
    }
}
