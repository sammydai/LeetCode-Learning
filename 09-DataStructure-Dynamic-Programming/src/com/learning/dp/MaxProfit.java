package com.learning.dp;

import com.sun.deploy.jardiff.JarDiff;

/**
 * @Package: com.learning.dp
 * @Description: 121. Best Time to Buy and Sell Stock
 * @Author: Sammy
 * @Date: 2022/2/23 09:58
 */

public class MaxProfit {
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

