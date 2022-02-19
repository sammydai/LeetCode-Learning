package com.learning.string;

import java.util.stream.StreamSupport;

/**
 * @Package: com.learning.string
 * @Description: 14. Longest Common Prefix
 * @Author: Sammy
 * @Date: 2022/2/15 12:23
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs==null||strs.length==0) {
			return "";
		}
		String template = strs[0];
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
