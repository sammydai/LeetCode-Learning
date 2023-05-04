package com.learning.string;

/**
 * 392. Is Subsequence
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/4/27 16:02]
 */
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int n = s.length();
		int y = t.length();
		int i = 0;
		int j = 0;
		while (i < n) {
			char cc = s.charAt(i);
			if ((t.indexOf(cc)) == -1) {
				return false;
			} else {
				t = t.substring(t.indexOf(cc) + 1);
				i++;
			}
		}
		return true;
	}
}
