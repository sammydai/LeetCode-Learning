package com.learning.hashcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Package: com.learning.juc
 * @Description:
 * @Author: Sammy
 * @Date: 2023/4/5 16:32
 */

public class HashMapDemo {
	public static void main(String[] args) {

		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("aa", 1);
		hashMap.put("bb", 2);
		hashMap.put("cc", 3);

		Iterator<String> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			if ("aa".equals(iterator.next())) {
				iterator.remove();
			}
		}
		System.out.println(hashMap);

		/*
		错误:这样写变成ConcurrentModificationException
		 */
		// for (String s : hashMap.keySet()) {
		// 	if (s.equals("2")) {
		// 		hashMap.remove("2");
		// 	}
		// }
	}
}

