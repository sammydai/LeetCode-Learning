package com.learning.binarysearch;

/**
 * 二分法
 * 167. Two Sum II - Input array is sorted
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/5 10:21]
 */
public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int i1 = search2(numbers, target - numbers[i], i + 1, numbers.length - 1);
			if (i1 == -1) {
				continue;
			} else {
				result = new int[]{i + 1, i1 + 1};
				break;
			}
		}
		return result;
	}

	public static int search2(int[] nums, int target, int start, int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 直接用二分法、双指针
	 *
	 * @param numbers 数字
	 * @param target  目标
	 * @return {@link int[]}
	 */
	public static int[] twoSum2(int[] numbers, int target) {
		int[] result = new int[2];
		int left = 0;
		int right = numbers.length - 1;
		while (left <= right) {
			int v = numbers[left] + numbers[right];
			if (v == target) {
				result = new int[]{left + 1, right + 1};
				break; //记得尽快退出
			} else if (v < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

}
