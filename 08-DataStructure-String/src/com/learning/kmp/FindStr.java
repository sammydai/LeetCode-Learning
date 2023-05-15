package com.learning.kmp;

/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/15 16:23]
 */
public class FindStr {
	public int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		char[] s = haystack.toCharArray();
		char[] p = needle.toCharArray();
		for (int i = 0; i <= n - m; i++) {
			int a = i;
			int b = 0;
			while (b < m && s[a] == p[b]) {
				a++;
				b++;
			}
			if (b == m) return i;
		}
		return -1;
	}
}
