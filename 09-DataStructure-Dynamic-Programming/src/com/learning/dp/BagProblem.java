package com.learning.dp;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/16 10:30]
 */
public class BagProblem {
	public static void main(String[] args) {
		int[] weight = {1, 3, 4};
		int[] value = {15, 20, 30};
		int bagSize = 4;
		testWeightBagProblem(weight, value, bagSize);
	}

	private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
		int goods = weight.length;
		int[][] dp = new int[goods][bagSize + 1];
		dp[0][0] = 0;
		for (int i = 0; i < goods; i++) {
			dp[i][0] = 0;
		}
		for (int j = weight[0]; j <= bagSize; j++) {
			dp[0][j] = value[0];
		}
		for (int i = 1; i < goods; i++) {
			for (int j = 1; j <= bagSize; j++) {
				if (j < weight[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}
		}
		for (int i = 0; i < goods; i++) {
			for (int j = 0; j <= bagSize; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}
	// dp[i][j]的含义：从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
	// dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
	// 当j<weight[0],dp[0][j]=0
	// 当j>weight[0],dp[0][j]=value[0]

}
