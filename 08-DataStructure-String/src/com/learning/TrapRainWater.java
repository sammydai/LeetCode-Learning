package com.learning;

/**
 * 42. Trapping Rain Water
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/21 13:19]
 */
public class TrapRainWater {
	public int trap(int[] height) {
		int a = 0;
		int max = 0;
		for (int i = 1; i < height.length - 1; i++) {

			//找到左边最大值
			int leftmax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (height[j] > leftmax) {
					leftmax = height[j];
				}
			}
			//找到右边最大值
			int rightmax = 0;
			for (int j = i + 1; j < height.length; j++) {
				if (height[j] > rightmax) {
					rightmax = height[j];
				}
			}
			int minheight = Math.min(leftmax, rightmax);
			if (minheight > height[i]) {
				max = max + (minheight - height[i]);
			}
		}
		return max;
	}

	public int trapNew(int[] height) {
		int sum = 0;
		int[] max_left = new int[height.length];
		int[] max_right = new int[height.length];

		for (int i = 1; i < height.length - 1; i++) {
			max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
		}

		for (int i = height.length - 2; i >= 0; i--) {
			max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
		}

		for (int i = 1; i < height.length - 1; i++) {
			//找到左边最大值
			int leftmax = max_left[i];
			//找到右边最大值
			int rightmax = max_right[i];
			int minheight = Math.min(leftmax, rightmax);
			if (minheight > height[i]) {
				sum = sum + (minheight - height[i]);
			}
		}
		return sum;
	}
}
