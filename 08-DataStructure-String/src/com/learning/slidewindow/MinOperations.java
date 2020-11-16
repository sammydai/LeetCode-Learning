package com.learning.slidewindow;

/**
 * @Package: com.learning.slidewindow
 * @Description: 1658. Minimum Operations to Reduce X to Zero
 * @Author: Sammy
 * @Date: 2020/11/16 11:19
 */

public class MinOperations {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 7, 1};
		int[] nums2 = {3, 2, 20, 1, 1, 3};
		System.out.println(minOperations(nums2,10 ));
	}
	public static int minOperations(int[] nums, int x) {
		int res = Integer.MAX_VALUE;
		int left = 0;
		int right = nums.length - 1;
		int rightPoint = nums.length - 1;
		int tempCount = 0;
		int leftSum = 0;
		int rightSum = 0;
		int tempSum = 0;
		while (left < nums.length && tempSum<x) {
			tempSum += nums[left];
			left++;
		}
		if (tempSum == x) {
			res = Math.min(res, left);
		}
		leftSum = tempSum;
		left--;
		tempSum = 0;

		while (right >= 0 && tempSum<x) {
			tempSum += nums[right];
			right--;
		}
		if (tempSum == x) {
			res = Math.min(res, nums.length - right-1);
		}
		rightSum = tempSum;
		right++;
		tempSum = 0;


		while (left >=0 && rightPoint>= right) {

			leftSum -= nums[left];
			leftSum += nums[rightPoint];
			if (leftSum == x) {
				res = Math.min(res, nums.length - right - 1 + left);
			}
				left--;
				rightPoint--;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
