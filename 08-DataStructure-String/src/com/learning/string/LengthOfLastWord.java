package com.learning.string;

/**
 * 58. Length of Last Word
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/21 12:07]
 */
public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		int result = 0;
		s = s.trim();
		if (s.length() == 0) return result;
		for (int i = s.length() - 1; i >= 0; ) {
			char cc = s.charAt(i);
			if (cc != ' ') {
				i--;
				result++;
			} else {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("luffy is still joyboy"));
	}
}
