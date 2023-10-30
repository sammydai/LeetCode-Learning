package com.learning.math;

/**
 * 66. Plus One
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/30 09:08]
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if (digits[i] != 0) return digits;
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
