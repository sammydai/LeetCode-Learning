package com.learning.string;

/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/7/10 14:39]
 */
public class FirstIndex {
	public static void main(String[] args) {
		System.out.println(new FirstIndex().strStr("leetcode", "leeto"));
	}

	public int strStr(String haystack, String needle) {
		char[] s = haystack.toCharArray();
		char[] t = needle.toCharArray();
		int n = haystack.length();
		int m = needle.length();
		for (int i = 0; i <= n - m; i++) {
			int a = i;
			int b = 0;
			while (b < m && s[a] == t[b]) {
				a++;
				b++;
			}
			if (b == m) {
				return i;
			}
			// } else {
			// 	return -1;
			// }
		}
		return -1;
	}
}

class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().strStr("leetcodeleeto", "leeto"));
	}

	public int strStr(String haystack, String needle) {
		char[] s = haystack.toCharArray();
		char[] t = needle.toCharArray();
		int n = s.length;
		int m = t.length;
		for (int i = 0; i <= n - m; i++) {
			int a = i;
			int b = 0;
			while (b < m && s[a] == t[b]) {
				a++;
				b++;
			}
			if (b == m) {
				return i;
			}
		}
		return -1;
	}
}

