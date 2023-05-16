package com.learning.dp;

/**
 * @Package: com.learning.dp
 * @Description: 62. Unique Paths
 * 63. Unique Paths II
 * @Author: Sammy
 * @Date: 2022/7/30 17:55
 */

public class UniquePaths {
	/**
	 * m x n grid
	 * 只能向下或者向右移动一步
	 *
	 * @param m 行
	 * @param n 列
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		//dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
		int[][] grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
			}
		}
		return grid[n - 1][m - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		//初始化列
		for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}
		//初始化行
		for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
			}
		}
		return dp[m - 1][n - 1];
	}
}
