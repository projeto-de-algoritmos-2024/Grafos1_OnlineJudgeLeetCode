package CountVisited;

import java.util.*;

public class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] result = new int[n];
        Map<Integer, Integer> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, edges.get(i));
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfs(i, graph, visited, result);
        }

        return result;
    }

    private int cycleLength(int node, Map<Integer, Integer> graph, Set<Integer> cycleVisited) {
        if (cycleVisited.contains(node)) {
            return cycleVisited.size();
        }
        cycleVisited.add(node);
        return cycleLength(graph.get(node), graph, cycleVisited);
    }

    private void updateLenght(int node, Map<Integer, Integer> graph, int[] result, int lenght) {
        if (result[node] > 0) return;
        result[node] = lenght;
        updateLenght(graph.get(node), graph, result, lenght);
    }

    private void dfs(int node, Map<Integer, Integer> graph, Set<Integer> visited, int[] result) {
        if (result[node] > 0) return;

        if (visited.contains(node)) {
            int cycleLenght = cycleLength(node, graph, new HashSet<>());
            updateLenght(node, graph, result, cycleLenght);
            return;
        }

        visited.add(node);
        dfs(graph.get(node), graph, visited, result);

        if (result[node] == 0) {
            result[node] = result[graph.get(node)] + 1;
        }
    }
}
