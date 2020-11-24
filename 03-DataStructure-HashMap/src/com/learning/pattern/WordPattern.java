package com.learning.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.hashmap
 * @Description: 290. Word Pattern
 * @Author: Sammy
 * @Date: 2020/11/7 20:06
 */

public class WordPattern {
		public boolean wordPattern(String pattern, String s) {
		String[] split = s.split(" ");
		if (split.length!=pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				if (map.containsValue(split[i])){
					return false;
				}
				map.put(pattern.charAt(i),split[i]);
			}else {
				if (!map.get(pattern.charAt(i)).equals(split[i])) {
					return false;
				}
			}
		}
		return true;
	}
}
