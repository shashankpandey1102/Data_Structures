package Graph;

public class cycle {
    public boolean cycleInGraph(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        boolean[] inStack = new boolean[edges.length];

        for(int i = 0; i < edges.length; i++){
            boolean containsCycle = checkCycle(i, edges, visited, inStack);

            if(containsCycle)
            return true;
        }
        return false;
      }

      public boolean checkCycle(int node, int[][] edges, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        boolean containsCycle = false;
        int[] neighbors = edges[node];

        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                containsCycle = checkCycle(neighbor, edges, visited, inStack);
            }
            if(containsCycle){
                return true;
            }
            else if(inStack[neighbor]){
                return true;
            }
        }

        inStack[node] = false;
        return false;
      }
}
