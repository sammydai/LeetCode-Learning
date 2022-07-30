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
}
