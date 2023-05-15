package com.learning.slidewin;

import java.util.ArrayList;
import java.util.List;


/**
 * 滑动窗口
 * right-left+1==》right-left 因为right本身会新增1，所以长度是right-left
 *
 * @author Sammy
 * @date 2023/05/05
 */
public class maxSubArrayLen {
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int[] nums2 = {3,9,6,-3};
		int[] nums3 = {1,2,3,4,5};
		System.out.println(minSubArrayLen2(7,nums));
		// System.out.println(minSubArrayLen1(25, nums2));
		// System.out.println(minSubArrayLen(7, nums));

	}

	/**
	 * Input: s = 7, nums = [2,3,1,2,4,3]
	 * Output: 2
	 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		int minResult = Integer.MAX_VALUE;
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int tempSum = 0;
			List<Integer> tempResult = new ArrayList<>();
			for (int j = i;j<nums.length;j++){
				tempSum+=nums[j];
				tempResult.add(nums[j]);
				if (tempSum>=s){
					int tempcount = j-i+1;
					minResult = minResult< tempcount?minResult:tempcount;
					result.add(tempResult);
					break;
				}
			}
		}
		System.out.println(result);
		return minResult;
	}

	public static int minSubArrayLen1(int s, int[] nums) {
		int minResult = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int tempSum = 0;
			for (int j = i;j<nums.length;j++){
				tempSum+=nums[j];
				if (tempSum==s){
					int tempcount = j-i+1;
					minResult = minResult< tempcount?minResult:tempcount;
					break;
				}
			}
		}
		return minResult==Integer.MAX_VALUE?0:minResult;
	}

	/**
	 * 左右两个指针
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen2(int s, int[] nums) {
		int minResult = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int tempSum = 0;
		int len = nums.length;
		while (right < len) {
			while (tempSum < s && right<len) {
				tempSum += nums[right];
				right++;
			}
			while (tempSum >= s) {
				minResult = Math.min(minResult, right - left);
				tempSum -= nums[left];
				left++;
			}
		}
		return minResult==Integer.MAX_VALUE?0:minResult;
	}
}
