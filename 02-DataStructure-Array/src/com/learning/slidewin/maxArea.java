package com.learning.slidewin;

/**
 * @Package: com.learning.slidewin
 * @Description: 11. Container With Most Water
 * @Author: Sammy
 * @Date: 2022/7/29 10:26
 */

public class maxArea {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		while (left < right) {
			int h = Math.min(height[left], height[right]);
			int l = right - left;
			int v = h * l;
			max = Math.max(max, v);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int i = 18 % 10;
		System.out.println(i);
	}

	public int maxAreaNew(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int res = 0;
		while (i < j) {
			res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
		}
		return res;
	}
}
