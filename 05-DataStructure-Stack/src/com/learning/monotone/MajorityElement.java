package com.learning.monotone;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/12 17:33]
 */
public class MajorityElement {
	public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		Map.Entry<Integer, Integer> res = null;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (res == null || entry.getValue() > res.getValue()) {
				res = entry;
			}
		}
		return res.getKey();
	}
}
