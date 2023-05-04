package com.learning.twopoints;

/**
 * 移除重复的值，置为0
 * 283. Move Zeroes
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/4 23:09]
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[left] = nums[i];
				left++;
			}
		}
		for (; left < nums.length; left++) {
			nums[left] = 0;
		}
	}
}
