package com.learning.slidewin;

/**
 * @Package: com.learning.slidewin
 * @Description: 395. Longest Substring with At Least K Repeating Characters
 * @Author: Sammy
 * @Date: 2022/7/28 15:31
 */

public class longestSubstring {

	public static void main(String[] args) {
		new longestSubstring().longestSubstring("bbaaacbd", 3);
	}
	public int longestSubstring(String s, int k) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] chars = new char[256];
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}
		boolean flag = true;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 0 && chars[i] < k) {
				flag = false;
			}
		}
		if (flag == true) {
			return s.length();
		}
		int result = 0;
		int start = 0;
		int cur = 0;
		while (cur < s.length()) {
			if (chars[s.charAt(cur)-'a'] < k) {
				result = Math.max(result, longestSubstring(s.substring(start, cur), k));
				start = cur + 1;
			}
			cur++;
		}
		result = Math.max(result, longestSubstring(s.substring(start), k));
		return result;
	}

	// private int helper(String s, int k, int start, int end) {
	// 	if (start>end) return 0;
	// 	int[] count = new int[256];
	//
	// }
}
