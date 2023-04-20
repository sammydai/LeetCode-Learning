package com.learning.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.hashtable
 * @Description: 1. Two Sum
 * @Author: Sammy
 * @Date: 2022/1/28 16:01
 */

public class TwoSum {
	 public int[] twoSum(int[] nums, int target) {
		 int[] result = new int[2];
		 Map<Integer, Integer> map = new HashMap<>();
		 for (int i = 0; i < nums.length; i++) {
			 if (map.containsKey(target - nums[i])) {
				 result[0] = i;
				 result[1] = map.get(target - nums[i]);
				 //直接退出去
				 break;
			 }
			 map.put(nums[i], i);
		 }
		 return result;
	 }

	public int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = i;
				result[1] = map.get(target - nums[i]);
				break;
			}
			map.put(i, nums[i]);
		}
		return result;
	}
}
