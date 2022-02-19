package com.learning.slidewin;

import com.sun.xml.internal.ws.config.management.policy.ManagementAssertionCreator;
import sun.font.TrueTypeFont;
import sun.jvm.hotspot.runtime.VM;
import sun.tools.tree.IfStatement;
import sun.util.resources.lt.CurrencyNames_lt_LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.slidewin
 * @Description: 76. Minimum Window Substring
 * @Author: Sammy
 * @Date: 2022/1/28 10:48
 */

public class minWindow {
	public String minWindow(String s, String t) {
		if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
		
		String minResult = "";
		int minLen = Integer.MAX_VALUE;
		int count = t.length();
		int minLeft = 0;
		int minRight = 0;
		boolean flag = false;
		Map<Character, Integer> hashMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}
		int i = 0;
		int j = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) - 1);
				if (hashMap.get(c)>=0) {
					count--;
				}
			}
			// 先找到一个窗口
			while (count == 0 && i <= j) {
				flag = true;
				int curLen = j - i + 1;
				if (curLen <= minLen) {
					minLeft = i;
					minRight = j;
					minLen = curLen;
				}
				// 缩小左窗口范围
				char leftC = s.charAt(i);
				if (hashMap.containsKey(leftC)) {
					hashMap.put(leftC, hashMap.get(leftC) + 1);
					if (hashMap.get(leftC)>=1) {
						count++;
					}
				}
				i++;
			}
			j++;
		}
		return flag == true ? s.substring(minLeft, minRight + 1): "";
	}
}
