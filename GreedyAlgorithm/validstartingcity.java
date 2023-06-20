package GreedyAlgorithm;

public class validstartingcity {
    
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;
        
        
        for(int i = 0; i < numberOfCities; i++){
            int milesRemaining = 0;
            for(int j = i; j < i+numberOfCities; j++){
                
                if(milesRemaining < 0)
                break;
                
                int currentCityIndex = j % numberOfCities;
                int distancesToNextCity = distances[currentCityIndex];
                int fuelAvalible = fuel[currentCityIndex];

                milesRemaining += mpg*fuelAvalible-distancesToNextCity;
                
            }

            if(milesRemaining >=0)
            return i;
        }

        return -1;
    }

    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
        int milesLeft = 0;
        int milesRemaining = 0;
        int minCity = 0;
    
        for(int i = 1; i < distances.length; i++){
          int distance = distances[i-1];
          int avalibleFuel = fuel[i-1];
          milesRemaining += avalibleFuel * mpg - distance;
    
          if(milesRemaining < milesLeft){
            milesLeft = milesRemaining;
            minCity = i;
          }
        }
        return minCity;
      }

    public static void main(String[] args) {
        System.out.println(validStartingCity1(new int[] {5, 25, 15, 10, 15}, new int[] {1, 2, 1, 0, 3}, 10));
    }
}
