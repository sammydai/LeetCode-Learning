package com.learning.hashmap;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/7/25 10:45]
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
