package com.learning;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning
 * @Description: 205. Isomorphic Strings
 * 举个例子，s = ab, t = cc，如果单看 s -> t ，那么 a -> c, b -> c 是没有问题的。
 * 必须再验证 t -> s，此时，c -> a, c -> b，一个字母对应了多个字母，所以不是同构的。
 * @Author: Sammy
 * @Date: 2022/7/3 14:59
 */

public class IsIsomorphic {
	public boolean isIsomorphic(String s, String t) {
		return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    public boolean isIsomorphic2(String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		boolean isomorphic = new IsIsomorphic().isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck");
		System.out.println(isomorphic);
	}

	public String isIsomorphicHelper(String s) {
		Map<Character, Integer> hashMap = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char keychar = s.charAt(i);
			if (!hashMap.containsKey(keychar)) {
				hashMap.put(keychar, i);

			}
			builder.append(hashMap.get(keychar)).append(" ");
		}
		return builder.toString();
	}
}
