package com.learning;

/**
 * @Package: com.learning
 * @Description: Leetcode Tag Sort
 * 				 242. Valid Anagram
 * @Author: Sammy
 * @Date: 2020/11/16 08:54
 */

public class LeeSort {

	/**
	 * 242. Valid Anagram
	 * 主要是int[] m数组，通过字符的ascii码作为下标
	 * 只有字符的搜索排序方法
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if (s==null && t==null) return true;
        if (s.length()!=t.length()) return false;
		int[] m = new int[26];
		for (int i = 0; i < s.length(); i++) {
			m[s.charAt(i) - 'a']++;
			m[t.charAt(i) - 'a']--;
		}
		for (int i : m) {
			if (i!=0) return false;
		}
		return true;
    }
}
