package com.learning.twopoints;

/**
 * @Package: com.learning.twopoints
 * @Description: 27. Remove Element
 * @Author: Sammy
 * @Date: 2022/2/17 10:06
 */

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=val) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}
}
