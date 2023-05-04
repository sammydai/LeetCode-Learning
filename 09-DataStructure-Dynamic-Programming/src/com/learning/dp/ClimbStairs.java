package com.learning.dp;


/**
 * 70. Climbing Stairs
 * 746. Min Cost Climbing Stairs
 * 初始化条件是什么
 * dp[]状态转移方程
 *
 * @author Sammy
 * @date 2023/04/28
 */
public class ClimbStairs {
	 public int climbStairs(int n) {
		 if (n<=2) {
			 return n;
		 }
		 int[] dp = new int[n + 1];
		 dp[1] = 1;
		 dp[2] = 2;
		 for (int i = 3; i <=n; i++) {
			 dp[i] = dp[i - 1] + dp[i - 2];
		 }
		 return dp[n];
	 }

	 public int minCostClimbingStairs(int[] cost) {
		 int len = cost.length;
		 int[] dp = new int[len];
		 int result = 0;
		 dp[0] = cost[0];
		 dp[1] = cost[1];
		 for (int i = 2; i < dp.length; i++) {
			 dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
		 }
		 // return dp[cost.length];
		 return Math.min(dp[len - 1], dp[len - 2]);
    }
}