class Solution {
  public int collectTheCoins(int[] coins, int[][] edges) {
      int n = coins.length;
      List<Set<Integer>> graph = initializeGraph(coins, edges);
      Queue<Integer> queue = new LinkedList<>();

      for(int i=0;i<n;i++){
          int currentNode=i;
          while(graph.get(currentNode).size()==1 && coins[currentNode]==0){
              int neighborNode = graph.get(currentNode).iterator().next();
              graph.get(currentNode).remove(neighborNode);
              graph.get(neighborNode).remove(currentNode);
              currentNode = neighborNode;
          }

          if (graph.get(currentNode).size()==1){
              queue.add(currentNode);
          }
      }


      for(int i=0;i<2;i++){
          List<Integer> temp=new ArrayList<>();

          while(!queue.isEmpty()){
              int currentNode = queue.remove();

              if(graph.get(currentNode).size()==1){
                  int neighborNode = graph.get(currentNode).iterator().next();
                  graph.get(currentNode).remove(neighborNode);
                  graph.get(neighborNode).remove(currentNode);

                  if(graph.get(neighborNode).size()==1){
                      temp.add(neighborNode);
                  }
              }
          }

          queue.addAll(temp);
      }

      return minimumCoins(graph);
  }

  private List<Set<Integer>> initializeGraph (int[] coins, int[][] edges) {
      List<Set<Integer>> graph = new ArrayList<>();
      int n = coins.length;

      for(int i=0;i<=n;i++){
          graph.add(new HashSet<>());
      }

      for(int[] e:edges){
          graph.get(e[0]).add(e[1]);
          graph.get(e[1]).add(e[0]);
      }

      return graph;
  }

  private int minimumCoins(List<Set<Integer>> graph) {
      int minimumCoins = 0;
      for (Set<Integer> neighbors : graph) {
          minimumCoins += neighbors.size();
      }

      return minimumCoins;
  }
}