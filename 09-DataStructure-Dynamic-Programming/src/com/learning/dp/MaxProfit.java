package com.learning.dp;


/**
 * 最大利润
 * 找到最大值、最小值，用贪心算法比较简单
 *
 * @author Sammy
 * @date 2023/04/28
 */
public class MaxProfit {

	public int maxProfitPlus(int[] prices) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			res = Math.max(res, prices[i] - min);
		}
		return res;
	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 1) {
			return 0;
		}
		int[] diff = new int[len];
		for (int i = 0; i < len - 1; i++) {
			diff[i] = prices[i + 1] - prices[i];
		}
		int[] dp = new int[len];
		dp[0] = Math.max(0, diff[0]);
		int profit = dp[0];
		for (int i = 1; i < len; i++) {
			dp[i] = Math.max(dp[i - 1] + diff[i], 0);
			profit = Math.max(profit, dp[i]);
		}
		return profit;
	}
}

