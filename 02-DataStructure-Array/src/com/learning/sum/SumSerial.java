package com.learning.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.array
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/7 20:03
 */

public class SumSerial {

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i],i);
		}
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (hashMap.containsKey(temp) && (hashMap.get(temp)!=i)){
				return new int[]{i,hashMap.get(temp)};
			}
		}
		return new int[]{};
	}

	/**
	 * V2 再写亿遍
	 * Input: nums = [2,7,11,15], target = 9
	 * Output: [0,1]
	 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumV2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp) && (i != map.get(temp))) {
				return new int[]{i, map.get(temp)};
			}
		}
		return new int[]{};
	}

	/**
	 * Input: nums = [1,2,3,4]
	 *	Output: [1,3,6,10]
	 *	Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
	 * @param nums
	 * @return
	 */
	public static int[] runningSum(int[] nums) {
		int[] result = new int[nums.length];
		if (nums.length==1||nums.length==0||nums==null){
			return nums;
		}
		result[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i-1]+nums[i];
		}
		return result;
	}
}
