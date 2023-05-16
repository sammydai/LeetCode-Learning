package com.learning;

/**
 * 88. Merge Sorted Array
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/16 15:39]
 */
public class MergeArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len1 = m - 1;
		int len2 = n - 1;
		int len = m + n - 1;
		int cur;
		while (len1 >= 0 && len2 >= 0) {
			nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
		}
		while (len1 >= 0) {
			nums1[len--] = nums1[len1--];
		}
		while (len2 >= 0) {
			nums1[len--] = nums2[len2--];
		}
	}
}
