package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class tournament {
    
    public String tournamentWinner(ArrayList<ArrayList<String>> competetions, ArrayList<Integer> results){
        String winnerFinal = "";
        HashMap<String, Integer> resultBoard = new HashMap<String, Integer>();
        int maxScore = 0;
        

        for(int i = 0; i < results.size(); i++){
            int score = 0;
            int winner = results.get(i) == 0 ? 1 : 0; 
            String winnerTeam = competetions.get(i).get(winner);

            if(resultBoard.containsKey(winnerTeam)){
                int result = resultBoard.get(winnerTeam) + 3;
                resultBoard.put(winnerTeam, result);
                score = result;
            }
            else{
                resultBoard.put(winnerTeam, 3);
                score = 3;
            }

            if(score > maxScore){
                maxScore = score;
                winnerFinal = winnerTeam;
            }
        }

        return winnerFinal;
    }
}
