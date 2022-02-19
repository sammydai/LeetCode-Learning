package com.learning.binarysearch;

/**
 * @Package: com.learning.binarysearch
 * @Description: 278. First Bad Version
 * @Author: Sammy
 * @Date: 2022/1/29 13:28
 */

public class FirstBadVersion {
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
		return n % 2 == 0 ? true : false;
	}
}
