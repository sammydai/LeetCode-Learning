package com.learning.dp;

/**
 * @Package: com.learning.dp
 * @Description: 53. Maximum Subarray
 * @Author: Sammy 理解之后就不难了
 * @Date: 2020/11/18 12:45
 */

public class MaxSubArray {
	 public int maxSubArray(int[] nums) {
		 int result = nums[0];
		 // int result = Integer.MIN_VALUE;
		 // 1、一开始取max 的初值为 0，然后发现当只有一个负数的时候会返回0，所以遍历取最值的时候，max或者min的初值应该取数组内部的值
		 if (nums.length == 1) {
			 return result;
		 }
		 int[] dp = new int[nums.length];
		 dp[0] = nums[0];
		 for (int i = 1; i < nums.length; i++) {
			 dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			 result = Math.max(result, dp[i]);
		 }
		 return result;
    }

	/**
	 * 再写一遍
	 * @param nums
	 * @return
	 */
	public int maxSubArrayV2(int[] nums) {
		int result = nums[0];
		// int result = Integer.MIN_VALUE;
		if (nums.length == 1) {
			 return result;
		 }
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			result = Math.max(result, dp[i]);
		}
		return result;
	}
}
