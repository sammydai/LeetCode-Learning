package com.learning.greedy;


/**
 * @Package: com.learning.greedy
 * @Description: 55. Jump Game
 * @Author: Sammy
 * @Date: 2020/11/24 21:21
 */

public class CanJump {
	public static void main(String[] args) {
		int[] num1 = {2, 3, 1, 1, 4};
		int[] num2 = {3, 2, 1, 0, 4};
		canJump(num1);
	}
	public static boolean canJump(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		for (int k = 0; k <= nums[0] && k < len; k++) {
			dp[k]++;
		}
		for (int i = 1; i < len; i++) {
			if (dp[i]!=0) {
				for (int j = 1; j <= nums[i] && j + i < len; j++) {
					dp[j + i]++;
					if (dp[len - 1] != 0) {
						// System.out.println(Arrays.toString(dp));
						return true;
					}
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		return dp[len - 1] != 0;
	}

	public static boolean canJump2(int[] nums) {
		int len = nums.length;
		int maxIndex = nums[0];
		for (int i = 0; i <= maxIndex; i++) {
			if (maxIndex>=len-1) return true;
			maxIndex = Math.max(maxIndex, i + nums[i]);
		}
		return nums.length == 1 ? true : false;
	}

	public static boolean canJumpU(int[] nums) {
		int pos = nums.length - 1;
		int rightmost = 0;
		for (int i = 0; i <= pos; i++) {
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				if (rightmost >= pos) {
					return true;
				}
			}
		}
		return false;
	}


}
