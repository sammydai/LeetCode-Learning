package com.learning.dp;


import java.util.Arrays;

/**
 * @Package: com.learning.dp
 * @Description: 300. Longest Increasing Subsequence
 * dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
 * @Author: Sammy
 * @Date: 2022/2/23 10:45
 */

public class LengthOfLIS {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if (len<=1) {
			return len;
		}

		int result = 1;
		int[] dp = new int[len];
		Arrays.fill(dp,1);
		for (int i = 0; i < len; i++) {
			for (int j=0;j<i;j++) {
				//说明i-->j，是递增的，所以要看dp[j]+1
				//位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}
}
