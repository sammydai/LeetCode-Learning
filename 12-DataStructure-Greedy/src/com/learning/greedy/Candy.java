package com.learning.greedy;

import java.util.Arrays;

/**
 * @Package: com.learning.greedy
 * @Description: 135. Candy
 * @Author: Sammy
 * @Date: 2022/7/29 10:55
 */

public class Candy {
	public int candy(int[] ratings) {
		int[] nums = new int[ratings.length];
		Arrays.fill(nums,1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			}
		}
		for (int j = ratings.length - 1; j > 0; j--) {
			if (ratings[j - 1] > ratings[j]) {
				nums[j - 1] = Math.max(nums[j] + 1, nums[j - 1]);
			}
		}
		int result = 0;
		for (int num : nums) {
			result += num;
		}
		return result;
	}
}
