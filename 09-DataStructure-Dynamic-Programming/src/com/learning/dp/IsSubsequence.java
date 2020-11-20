package com.learning.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning.dp
 * @Description: 392. Is Subsequence
 * @Author: Sammy
 * @Date: 2020/11/20 09:15
 */

public class IsSubsequence {
	public static void main(String[] args) {
		System.out.println(allSubSequence3("ape"));
		// System.out.println(allSubSequence("ape"));
	}

	public static List<List<String>> allSubSequence(String t) {
		List<List<String>> result = new ArrayList<>();
		helper2(result, new ArrayList<>(), t, 0,2);
		return result;
	}

	public static List<String> allSubSequence3(String t) {
		List<String> result = new ArrayList<>();
		helper3(result, new StringBuffer(), t, 0,2);
		return result;
	}

	private static void helper(List<String> result, String tempResult, String t,  int index,int n) {
		if (index == t.length()) {
			System.out.println(tempResult);
			return;
		}
		// if (tempResult.length()==n){
		// 	result.add(tempResult);
		// }

		helper(result,tempResult+t.charAt(index),t,index+1,n);
		helper(result,tempResult,t,index+1,n);
	}

	private static void helper2(List<List<String>> result, List<String> tempResult, String t,  int index,int n) {
		if (tempResult.size() == n) {
			result.add(new ArrayList<>(tempResult));
		}
		for (int i = index; i < t.length(); i++) {
			tempResult.add(String.valueOf(t.charAt(i)));
			helper2(result, tempResult, t, i+1, n);
			tempResult.remove(tempResult.size() - 1);
		}
	}

	private static void helper3(List<String> result, StringBuffer tempResult, String t,  int index,int n) {
		if (tempResult.length() == n) {
			result.add(new String(tempResult));
		}
		for (int i = index; i < t.length(); i++) {
			tempResult.append(t.charAt(i));
			helper3(result, tempResult, t, i+1, n);
			tempResult.deleteCharAt(tempResult.length() - 1);
		}
	}
}
