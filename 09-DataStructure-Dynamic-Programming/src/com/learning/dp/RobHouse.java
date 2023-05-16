package com.learning.dp;


/**
 * 抢房子
 * 状态转移方程 初始化大小要考虑
 * dp中的i表示 抢第i+1个房子
 * 比如dp[0] ==>抢第1个房子
 * 比如dp[1] ==>抢第2个房子
 * 213. House Robber II
 *
 * @author Sammy
 * @date 2023/04/28
 */
public class RobHouse {
	public static void main(String[] args) {
		System.out.println(new RobHouse().rob2(new int[]{2, 3, 2}));
	}

	public int rob(int[] nums) {
		if (nums.length == 1) return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			//抢第i家+不抢第i家 =  抢第i-2家+这一家的收益， 抢第i-1家收益
			//dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	public int rob2(int[] nums) {
		if (nums.length == 1) return nums[0];
		int len = nums.length;
		return Math.max(robAction(nums, 0, len - 2), robAction(nums, 1, len - 1));
	}

	private int robAction(int[] nums, int start, int end) {
		if (end == start) return nums[start];
		int[] dp = new int[nums.length];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[end];
	}
}
