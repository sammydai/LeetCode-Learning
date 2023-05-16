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

	//dp[i][0] 表示第i天持有股票所得最多现金
	//dp[i][1] 表示第i天不持有股票所得最多现金
	public int maxProfitDP(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[][] dp = new int[prices.length][2];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
		}
		return dp[prices.length - 1][1];
	}

	//dp[i][0] 表示第i天持有股票所得最多现金
	//dp[i][1] 表示第i天不持有股票所得最多现金
	public int maxProfitDP2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		//可以多次买卖股票
		int[][] dp = new int[prices.length][2];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
		}
		return dp[prices.length - 1][1];
	}

	//dp[i][0] 表示第i天持有股票所得最多现金
	//dp[i][1] 表示第i天不持有股票所得最多现金
	//You may complete at most two transactions.

	/**
	 * 一天一共就有五个状态，
	 * <p>
	 * 0没有操作 （其实我们也可以不设置这个状态）
	 * 1第一次持有股票
	 * 2第一次不持有股票
	 * 3第二次持有股票
	 * 4第二次不持有股票
	 *
	 * @param prices
	 * @return
	 */
	public int maxProfitDP3(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		//可以多次买卖股票
		int[][] dp = new int[prices.length][5];
		dp[0][1] = -prices[0];
		dp[0][3] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			//第一次持有
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			//第一次不持有
			dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
			//第二次持有
			dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
			//第二次不持有
			dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
		}
		return dp[prices.length - 1][4];
	}

	public int maxProfitDP4(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		// 天数，次数，持有/不持有
		int[][][] dp = new int[len][k + 1][2];
		for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[i];
		}
		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= k; j++) {
				// dp方程, 0表示不持有/卖出, 1表示持有/买入
				dp[i][j][0] = Math.max(dp[i - 1][j][1], dp[i - 1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][0] - prices[i]);
			}
		}
		return dp[len - 1][k][0];
	}

	public int maxProfitDP5(int k, int[] prices) {
		if (prices.length == 0) return 0;

		// [天数][股票状态]
		// 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
		int len = prices.length;
		int[][] dp = new int[len][k * 2 + 1];

		// dp数组的初始化, 与版本一同理
		for (int i = 1; i < k * 2; i += 2) {
			dp[0][i] = -prices[0];
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < k * 2 - 1; j += 2) {
				//持有
				dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
				//卖出
				dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
			}
		}
		return dp[len - 1][k * 2];
	}
}

