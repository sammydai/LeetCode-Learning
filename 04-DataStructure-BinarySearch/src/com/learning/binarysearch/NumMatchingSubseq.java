package com.learning.binarysearch;

import java.util.HashSet;

/**
 * @Package: com.learning.dp
 * @Description: 792. Number of Matching Subsequences
 * @Author: Sammy
 * @Date: 2020/11/20 22:42
 */

public class NumMatchingSubseq {
	public int numMatchingSubseq(String S, String[] words) {
		int res = 0;
		HashSet<String> isSubSet = new HashSet<>();
		HashSet<String> noSubSet = new HashSet<>();
		for (String word : words) {
			if (isSubSet.contains(word)) {
				res++;
				continue;
			}
			if (noSubSet.contains(word)) {
				continue;
			}
			if (isSubsequence(word, S)) {
				isSubSet.add(word);
				res++;
			} else {
				noSubSet.add(word);
			}
		}
		return res;
	}

	public static boolean isSubsequence(String s, String t) {
		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i)==t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
	}
}
