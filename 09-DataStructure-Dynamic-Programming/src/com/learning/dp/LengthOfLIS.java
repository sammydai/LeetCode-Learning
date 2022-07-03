package com.learning.dp;

import com.sun.deploy.resources.Deployment_pt_BR;

import java.util.Arrays;

/**
 * @Package: com.learning.dp
 * @Description: 300. Longest Increasing Subsequence
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
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}
}
