package com.learning.twopoints;


/**
 * 删除元素
 * 左右指针: 左指针--下一个将要赋值的位置 右指针--当前要处理的元素
 *
 * @author Sammy
 * @date 2023/04/27
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int left = 0;
		int n = nums.length;
		for (int right = 0; right < n; right++) {
			if (nums[right] != val) {
				nums[left] = nums[right];
				left++;
			}
		}
		return left;
	}
}
