package com.learning.binarysearch;

/**
 * @Package: com.learning.binarysearch
 * @Description: 278. First Bad Version
 * 				 367. Valid Perfect Square
 *				 374. Guess Number Higher or Lower
 *				 744. Find Smallest Letter Greater Than Target
 * @Author: Sammy
 * @Date: 2020/11/9 12:59
 */

public class LeeBinarySearch {

	/**
	 * 278. First Bad Version
	 * 二分法:第一个等于值的
	 * You are given an API bool isBadVersion(version) which returns whether version is bad.
	 * Implement a function to find the first bad version.
	 * You should minimize the number of calls to the API.
	 * @param n
	 * @return
	 */
	public int firstBadVersion(int n) {
		 int low = 0;
		int high = n;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (isBadVersion(mid)) {
				if (mid == 0 || !isBadVersion(mid - 1)) {
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

	private boolean isBadVersion(int n) {
		return true;
	}

	/**
	 * 367. Valid Perfect Square
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
        long low = 1;
		long high = num;
		while (low <= num) {
			long mid = low + ((high - low) / 2);
			long tempResult = mid * mid;
			if (tempResult == num) {
				return true;
			} else if (tempResult > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
    }

	/**
	 * Given an array of integers nums containing n + 1 integers
	 * where each integer is in the range [1, n] inclusive.
	 * There is only one duplicate number in nums, return this duplicate number.
	 * @return
	 */
	// public int findDuplicate(int[] nums) {
		// int low = 0;
		// int high = nums.length - 1;
		// while (low <= high) {
		// 	int mid = low + (high - low) / 2;
		// 	int cnt = 0;
		// 	for (int i = 0; i < nums.length; i++) {
		// 		if (nums[i] <= mid) {
		// 			cnt++;
		// 		}
		// 	}
		// 	// if (cnt>mid)
		// 	// {1,2,4,5,4,3,6}
		//
		// }
    // }

	/**
	 * 374. Guess Number Higher or Lower
	 * @param n
	 * @return
	 */
	public static int guessNumber(int n) {
		int low = 1;
		int high = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == -1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
    }

	public static int guess(int num) {
		if (num==6) {
			return 0;
		} else if (num < 6) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 744. Find Smallest Letter Greater Than Target
	 * @param letters
	 * @param target
	 * @return
	 */
	public static char nextGreatestLetter(char[] letters, char target) {
		int low = 0;
		int high = letters.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (letters[mid] > target) {
				if (mid == 0 || letters[mid - 1] <= target) {
					return letters[mid];
				} else {
					high = mid - 1;
				}
			}  else {
				low = mid + 1;
			}
		}
		return letters[0];
    }

	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(nextGreatestLetter(letters, 'j'));
	}

}
