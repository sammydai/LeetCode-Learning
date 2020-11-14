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
		System.out.println(new Partition().partition("bc"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s.length() == 0 || s == null) {
			return result;
		}
		List<String> tempResult = new ArrayList<>();
		helper(s,tempResult,result);
		return result;
	}

	public void helper(String s, List<String> tempResult, List<List<String>> result) {
		if (s.length()==0||s==null) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		int len = s.length();
		for (int i = 1; i <=len; i++) {
			String substring = s.substring(0, i);
			if (isPalindrome(substring)) {
				tempResult.add(substring);
				helper(s.substring(i),tempResult,result);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s){
		if(s==null||s.length()==0)
			return true;
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
