public class Main {
    public static void main(String[] args) {
        //        Input: n = 4, relations = [[2,1],[3,1],[1,4]], k = 2
        //        Output: 3
        //        Explanation: The figure above represents the given graph.
        //                In the first semester, you can take courses 2 and 3.
        //        In the second semester, you can take course 1.
        //        In the third semester, you can take course 4.

        Solution solution = new Solution();
        int n = 4;
        int[][] relations = {{2, 1}, {3, 1}, {1, 4}};
        int k = 2;

        int result = solution.minNumberOfSemesters(n, relations, k);
        System.out.println(result);
    }
}