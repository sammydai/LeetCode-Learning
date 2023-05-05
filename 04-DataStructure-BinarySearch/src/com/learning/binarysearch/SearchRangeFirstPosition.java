package com.learning.binarysearch;

/**
 * SearchRangeFirstPosition
 * 二分查找法：查找第一个等于value的元素位置
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/5 11:28]
 */
public class SearchRangeFirstPosition {
	public static int bsearchFirstOccur(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (a[mid] == value) {
				if ((mid == 0) || a[mid - 1] != value) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
