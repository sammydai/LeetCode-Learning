package com.learning.linkedlist;

/**
 * @Package: com.learning.linkedlist
 * @Description: 26. Remove Duplicates from Sorted Array
 * @Author: Sammy
 * @Date: 2022/2/17 11:03
 */

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0){
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
                j++;
			}
		}
		return j;
		// int i = 0;
		// for (int j = 1; j < nums.length; j++) {
		// 	if (nums[i] != nums[j]) {
		// 		nums[i] = nums[j];
		// 		i++;
		// 	}
		// }
		// return i + 1;
    }
}
