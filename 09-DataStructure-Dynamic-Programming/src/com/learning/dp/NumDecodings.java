package com.learning.dp;

import com.sun.deploy.resources.Deployment_pt_BR;

import java.util.ArrayList;

/**
 * @Package: com.learning.dp
 * @Description: 91. Decode Ways
 * @Author: Sammy
 * @Date: 2022/1/29 15:05
 */

public class NumDecodings {
	public int numDecodings(String s) {
		if (s.isEmpty()||s.charAt(0)=='0') {
			return 0;
		}
		int size = s.length();
		//dp[i] 表示s中前i个字符组成的子串的解码方法的个数
		//
		int[] dp  = new int[size + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
			if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))){
			 	dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}
}
