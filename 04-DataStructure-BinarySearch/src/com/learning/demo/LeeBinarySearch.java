package com.learning.demo;

/**
 * @Package: com.learning.demo
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/9 12:59
 */

public class LeeBinarySearch {

	/**
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
}
