class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] firstEdge = null;
        int[] currentEdge = null;
        
        int[] fathers = new int[edges.length + 1];
        
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            if (fathers[destination] > 0) {
                firstEdge = new int[] {fathers[destination], destination};
                currentEdge = edge;
                break;
            }

            fathers[destination] = source;
        }

        int[] originHistory = new int[edges.length + 1];

        if (firstEdge == null) {
            for (int[] edge : edges) {
                int source = edge[0];
                int destination = edge[1];

                int sourceFather = findFather(source, originHistory);
                int destinationFather = findFather(destination, originHistory);

                if (sourceFather == destinationFather) {
                    return edge;
                }

                originHistory[destinationFather] = source;
            }
        } else {
            for (int[] edge : edges) {
                if (edge == currentEdge) continue;

                int source = edge[0];
                int destination = edge[1];

                int sourceFather = findFather(source, originHistory);
                int destinationFather = findFather(destination, originHistory);

                if (sourceFather == destinationFather) {
                    return firstEdge;
                }

                originHistory[destinationFather] = source;
            }
            return currentEdge;
        }

        return new int[0];
    }
    
    int findFather(int v, int[] father) {
        if (father[v] == 0) {
            father[v] = v;
        }
        if (father[v] != v) {
            father[v] = findFather(father[v], father);
        }
        return father[v];
    }
}