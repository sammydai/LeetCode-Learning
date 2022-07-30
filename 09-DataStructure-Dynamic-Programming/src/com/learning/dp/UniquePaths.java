package com.learning.dp;

/**
 * @Package: com.learning.dp
 * @Description: 62. Unique Paths
 * @Author: Sammy
 * @Date: 2022/7/30 17:55
 */

public class UniquePaths {
	/**
	 * m x n grid
	 * @param m 行
	 * @param n 列
	 * @return
	 */
	public int uniquePaths(int m, int n) {
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
}
