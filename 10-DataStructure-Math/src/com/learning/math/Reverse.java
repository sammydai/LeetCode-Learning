package com.learning.math;

/**
 * @Package: com.learning.math
 * @Description: 7. Reverse Integer
 * @Author: Sammy
 * @Date: 2022/2/15 13:11
 */

public class Reverse {
	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			// 和求回文数字一致
			if (Math.abs(result)>Integer.MAX_VALUE/10) {
				return 0;
			}
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result;
	}

}
