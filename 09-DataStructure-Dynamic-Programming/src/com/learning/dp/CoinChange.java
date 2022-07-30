package com.learning.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Package: com.learning.dp
 * @Description: 322. Coin Change
 * @Author: Sammy
 * @Date: 2022/7/30 22:14
 */

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp,amount+1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					//if (coin <= i && dp[i-coin]<=amount) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
