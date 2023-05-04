package com.learning.pattern;

import java.util.HashMap;
import java.util.Map;


/**
 * 字模式
 *
 * @author Sammy
 * @date 2023/04/27
 */
public class WordPattern {
	/**
	 * 字模式
	 * 考虑情况 "abba" "dog dog dog dog"
	 * 需要判断key对应的值没有出现在map中
	 * 遍历第一个字符a-dog，放入map中
	 * 遍历第二个字符b-dog，key-b没有出现过，所以也会放入map中
	 * 但此时value值已出现过，所以当key值没出现过的时候，还要继续判断value值有没有出现过
	 * 即map.containsValue()
	 * @param pattern 模式
	 * @param s       年代
	 * @return boolean
	 */
	public boolean wordPattern(String pattern, String s) {
		String[] split = s.split(" ");
		if (split.length != pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				if (map.containsValue(split[i])) {
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
