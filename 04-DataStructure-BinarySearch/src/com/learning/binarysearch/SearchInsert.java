package com.learning.binarysearch;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_USM;

import java.util.concurrent.TransferQueue;

/**
 * @Package: com.learning.binarysearch
 * @Description: 35. Search Insert Position
 * @Author: Sammy
 * @Date: 2022/1/29 14:11
 */

public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		if (target>nums[high]) return nums.length;
		if (target<nums[0]) return 0;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] >= target) {
				if (mid == 0 || nums[mid - 1] < target) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}
		return -1;
    }

	public static void main(String[] args) {
		int[] aa = {2,3,5,6};
		int[] bb = {1};
		int i1 = new SearchInsert().searchInsert(aa, 5);
		System.out.println(i1);
	}
}
