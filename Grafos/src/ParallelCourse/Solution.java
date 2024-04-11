package ParallelCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        for (int[] r : relations) {
            pre[r[1] - 1] |= 1 << (r[0] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); ++i) {
            int canStudy = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & pre[j]) == pre[j]) {
                    canStudy |= 1 << j;
                }
            }
            canStudy &= ~i;
            for (int sub = canStudy; sub > 0; sub = (sub - 1) & canStudy) {
                if (Integer.bitCount(sub) <= k) {
                    dp[i | sub] = Math.min(dp[i | sub], dp[i] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
