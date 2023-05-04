package com.learning.dp;


/**
 * 抢房子
 * 状态转移方程 初始化大小要考虑
 * dp中的i表示 抢第i+1个房子
 * 比如dp[0] ==>抢第1个房子
 * 比如dp[1] ==>抢第2个房子
 *
 * @author Sammy
 * @date 2023/04/28
 */
public class RobHouse {
	public int rob(int[] nums) {
		if (nums.length==1) return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length -1];
    }
}
