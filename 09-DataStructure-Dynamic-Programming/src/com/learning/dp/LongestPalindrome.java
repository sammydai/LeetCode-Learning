package com.learning.dp;

/**
 * @Package: com.learning.dp
 * @Description: 5. Longest Palindromic Substring
 * @Author: Sammy
 * @Date: 2020/11/18 13:30
 */

public class LongestPalindrome {
	public String longestPalindrome(String s) {
		if (s.length()==0) {
			return "";
		}
		if (s.length()==1) {
			return s;
		}
		// dp[i][j],表示字符串str从str[i]到str[j]的子串为最长回文子串
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxLen = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		// 获得dp[i][j]必须先有 dp[i + 1][j - 1]所以i必须是从高位到低位取值
		for (int i = s.length()-1; i >=0; i--) {
			for (int j = i; j < s.length() ; j++) {
				if (i==j) {
					dp[i][j] = true;
				}
				else if (j - i == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) ? true : false;
				}
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					start = i;
					end = j;
				}
			}
		}
		return s.substring(start, end+1);
    }

	public static void main(String[] args) {
		String aa = "babad";
		System.out.println(new LongestPalindrome().longestPalindrome(aa));
	}
}
