package com.learning.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.string
 * @Description: 387. First Unique Character in a String
 * @Author: Sammy
 * @Date: 2020/11/21 21:48
 */

public class FirstUniqString {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			if (hashMap.get(s.charAt(i))==1) {
				return i;
			}
		}
		return -1;
    }

    public int firstUniqChar2(String s) {
		int[] num = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			num[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (num[cc-'a']==1) {
				return i;
			}
		}
		return -1;
    }
}
