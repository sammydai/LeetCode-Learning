package com.learning.string;

/**
 * 125. Valid Palindrome
 * 回文字符串，跳过非字符和数字+统一大小写
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/4/26 17:16]
 */
public class PalindromeSentence {
	public boolean isPalindrome(String s) {
		int n = s.length();
		int left = 0;
		int right = n - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			if (left < right) {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				} else {
					left++;
					right--;
				}
			}
		}
		return true;
	}
}
