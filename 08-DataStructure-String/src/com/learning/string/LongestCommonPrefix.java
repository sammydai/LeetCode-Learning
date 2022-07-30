package com.learning.string;

import sun.jvm.hotspot.runtime.ResultTypeFinder;

/**
 * @Package: com.learning.string
 * @Description: 14. Longest Common Prefix
 * @Author: Sammy
 * @Date: 2022/2/15 12:23
 */

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] test ={"flower","flow","owner"};
		String result = new LongestCommonPrefix().longestCommonPrefix(test);
		System.out.println(result);
	}
	public String longestCommonPrefix(String[] strs) {
		if (strs==null||strs.length==0) {
			return "";
		}
		String template = strs[0];
		int count = strs.length;
		for (int i = 0; i < template.length(); i++) {
			Character compareNum = template.charAt(i);
			for (int j = 1; j < count; j++) {
				//这个条件想不到的，只能想到不相等的时候
				//最关键的问题是，遍历完第二个str之后，就会遍历第三个str，
				// 而不是把第二个str的字符串全部遍历完，所以当举例的时候，发现第三个str"owner"，和第一个字符"f"不一致，就直接返回
				if (i==strs[j].length()||compareNum!=strs[j].charAt(i)) {
					return template.substring(0, i);
				}
			}
		}
		return template;
	}

	public String longestCommonPrefix2(String[] strs) {
		if (strs==null ||strs.length==0) return "";
		String template =  strs[0];
		int count = strs.length;
		for (int i = 0; i < template.length(); i++) {
			Character compareNum = template.charAt(i);
			for (int j = 1; j < count; j++) {
				if (i==strs[j].length()||compareNum!=strs[j].charAt(i)) {
					return template.substring(0, i);
				}
			}
		}
		return template;
	}
}
