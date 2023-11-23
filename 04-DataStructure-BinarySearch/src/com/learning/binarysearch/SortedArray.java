package com.learning.binarysearch;

/**
 * 33. Search in Rotated Sorted Array
 * 二分法
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/11/23 16:15]
 */
public class SortedArray {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[0] <= nums[mid]) {
				if (nums[0] <= target && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[nums.length - 1]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
