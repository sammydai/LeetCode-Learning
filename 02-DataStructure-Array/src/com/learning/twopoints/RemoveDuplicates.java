package com.learning.twopoints;


/**
 * 删除重复
 * 26. Remove Duplicates from Sorted Array
 * 80. Remove Duplicates from Sorted Array II
 *
 * @author Sammy
 * @date 2023/05/04
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0){
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int slow = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[slow] = nums[i];
				slow++;
			}
		}
		return slow;
	}

	public int removeDuplicatesNew(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		int slow = 2;
		for (int i = 2; i < nums.length; i++) {
			// if (nums[i] != nums[i - 2]) { //出错
			if (nums[i] != nums[slow - 2]) {
				nums[slow] = nums[i];
				slow++;
			}
		}
		return slow;
	}

}
