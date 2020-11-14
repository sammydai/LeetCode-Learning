package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 131. Palindrome Partitioning
 * @Author: Sammy
 * @Date: 2020/11/14 15:35
 */

public class Partition {
	public static void main(String[] args) {
		System.out.println(isPalindrome("bc"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> tempResult = new ArrayList<>();
		return result;
	}

	public void helper(){

	}

	public static boolean isPalindrome(String s){
		int left = 0;
		int right = s.length()-1;
		while (left<right){
			if (s.charAt(left)==s.charAt(right)) {
				left++;
				right--;
			}else {
				return false;

			}
		}
		return true;
	}
}
