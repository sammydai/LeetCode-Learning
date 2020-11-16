package com.learning.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.slidewindow
 * @Description: 76. Minimum Window Substring
 * @Author: Sammy
 * @Date: 2020/11/16 09:29
 */

public class MinWindow {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	public static String minWindow(String s, String t) {
		String res = "";
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return res;
		}
		Map<Character, Integer> tmap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char tchar = t.charAt(i);
			if (tmap.containsKey(tchar)) {
				tmap.put(tchar, tmap.get(tchar) + 1);
			} else {
				tmap.put(tchar, 1);
			}
		}
		int count = 0;
		int left = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char schar = s.charAt(i);
			if (tmap.containsKey(schar)) {
				tmap.put(schar, tmap.get(schar) - 1);
				if (tmap.get(schar) >= 0) {
					count++;
				}
				while (count == t.length()) {
					if (i-left+1<minLen) {
						minLen = i - left + 1;
						res = s.substring(left, i+1);//
					}
					if (tmap.containsKey(s.charAt(left))) {
						tmap.put(s.charAt(left), tmap.get(s.charAt(left)) + 1);
						if (tmap.get(s.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		return res;
	}
}
