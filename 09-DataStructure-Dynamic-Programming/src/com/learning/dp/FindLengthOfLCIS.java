package com.learning.dp;

import java.util.Arrays;

/**
 * 674. Longest Continuous Increasing Subsequence
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/16 12:05]
 */
public class FindLengthOfLCIS {
	public int findLengthOfLCIS(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return len;
		}

		int result = 1;
		int[] dp = new int[len];
		Arrays.fill(dp, 1);
		for (int i = 1; i < len; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}
}
