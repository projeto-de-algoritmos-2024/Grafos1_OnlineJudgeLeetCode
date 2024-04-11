import CountVisited.Solution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Para o exercício Parallel Course, basta descomentar o código abaixo e comentar os demais
        //        1494. Parallel Courses. Exemplo abaixo:
        //        Input: n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
        //        Output: 3
        //        Explanation: The figure above represents the given graph.
        //                In the first semester, you can take courses 2 and 3.
        //        In the second semester, you can take course 1.
        //        In the third semester, you can take course 4.

//        Solution solution = new Solution();
//        int n = 4;
//        int[][] relations = {{2, 1}, {3, 1}, {1, 4}};
//        int k = 2;
//
//        int result = solution.minNumberOfSemesters(n, relations, k);
//        System.out.println(result);


        // Para o exercício CountVisited, basta descomentar o código abaixo e comentar os demais
        //        2876. Count Visited Nodes in a Directed Graph. Exemplo abaixo:
        //        Input: edges = [1,2,0,0]
        //        Output: [3,3,3,4]
        //        Explanation: We perform the process starting from each node in the following way:
        //        - Starting from node 0, we visit the nodes 0 -> 1 -> 2 -> 0. The number of different nodes we visit is 3.
        //        - Starting from node 1, we visit the nodes 1 -> 2 -> 0 -> 1. The number of different nodes we visit is 3.
        //        - Starting from node 2, we visit the nodes 2 -> 0 -> 1 -> 2. The number of different nodes we visit is 3.
        //        - Starting from node 3, we visit the nodes 3 -> 0 -> 1 -> 2 -> 0. The number of different nodes we visit is 4.

        Solution countVisitedSolution = new Solution();
        List<Integer> edges = List.of(1, 2, 0, 0);
        int[] result = countVisitedSolution.countVisitedNodes(edges);
        for (int i : result) {
            System.out.println(i);
        }
    }
}