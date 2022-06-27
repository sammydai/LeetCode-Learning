package com.learning.hashtable;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import javax.security.auth.kerberos.KerberosKey;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.hashtable
 * @Description: 242. Valid Anagram
 * @Author: Sammy
 * @Date: 2022/1/27 09:31
 */

public class IsAnagram {
	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> hashMap = new HashMap<>();
		int slength = s.length();
		int tlength = t.length();
		if (slength!=tlength) {
			return false;
		}
		for (int i = 0; i < slength; i++) {
			//关键是想到hashMap数据结构
			hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
			hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) - 1);
		}
		for (Character character : hashMap.keySet()) {
			if (hashMap.get(character) != 0) {
				return false;
			}
		}
		return true;
	}
}
