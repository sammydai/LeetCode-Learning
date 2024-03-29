package com.learning.dp;

/**
 * @Package: com.learning.dp
 * @Description: 64. Minimum Path Sum
 * @Author: Sammy
 * @Date: 2022/7/30 13:17
 */

public class MinPathSum {
	public int minPathSum(int[][] grid) {
 		// if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
          //   return 0;
 		int m = grid.length ;
        int n = grid[0].length ;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int j = 1; j < m; j++) {
			dp[j][0] = dp[j - 1][0] + grid[j][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
			}
		}
        return dp[m - 1][n - 1];
    }
}
