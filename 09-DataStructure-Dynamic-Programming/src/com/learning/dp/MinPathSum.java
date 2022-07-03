package com.learning.dp;

/**
 * @Package: com.learning.dp
 * @Description: 64. Minimum Path Sum
 * @Author: Sammy
 * @Date: 2022/2/23 13:17
 */

public class MinPathSum {
	public void minPathSum(int[][] grid) {
 		// if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
          //   return 0;
 		int r = grid.length - 1;
        int c = grid[0].length - 1;
        int[][] dp = new int[r + 1][c + 1];
        dp[0][0] = grid[0][0];

    }
}
