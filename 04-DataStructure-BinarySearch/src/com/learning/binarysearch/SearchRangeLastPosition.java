package com.learning.binarysearch;

/**
 * 二分法变形：查找最后一个等于value的元素位置
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/5 11:46]
 */
public class SearchRangeLastPosition {
	public static int bsearchLastOccur(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (a[mid] == value) {
				if ((mid == n - 1) || a[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
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
