package com.learning.binarysearch;

/**
 * @Package: com.learning.binarysearch
 * @Description: 34. Find First and Last Position of Element in Sorted Array
 * @Author: Sammy
 * @Date: 2022/1/28 16:19
 */

public class SearchRange {
	public int[] searchRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums == null || nums.length == 0) {
			return result;
		}
		int n = nums.length;
		int low = 0;
		int high = n-1;
		int left = findfirsttargetnum(nums, target, low, high);
		int right = findlasttargetnum(nums, target, low, high);
		result[0] = left;
		result[1] = right;
		return result;
	}

	private int findlasttargetnum(int[] nums, int target, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == high || nums[mid + 1] != target) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private int findfirsttargetnum(int[] nums, int target, int low, int high) {
		while (low <= high) {
			int mid = (high+low)/2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid - 1] != target) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] aa = {5,7,7,8,8,10};
		int[] bb = {1};
		int[] result = new SearchRange().searchRange(aa, 8);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
