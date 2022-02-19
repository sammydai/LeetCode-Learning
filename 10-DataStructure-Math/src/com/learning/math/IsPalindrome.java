package com.learning.math;

/**
 * @Package: com.learning.math
 * @Description: 9. Palindrome Number
 * @Author: Sammy
 * @Date: 2022/2/16 17:05
 */

public class IsPalindrome {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int res = 0;
		int y = x;
		while (y != 0) {
			if (res > Integer.MAX_VALUE / 10) return false;
			res=res*10+y%10;
			y /= 10;
		}
		return res == x;
    }

	public static void main(String[] args) {
		System.out.println(new IsPalindrome().isPalindrome(121));
	}
}
