package com.learning.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.learning.dp
 * @Description: 392. Is Subsequence
 * @Author: Sammy
 * @Date: 2020/11/20 09:15
 */

public class IsSubsequence {
	public static void main(String[] args) {
		// System.out.println(isSubsequence("pe", "ape"));
		System.out.println(isSubsequence2("pe", "ape"));
		// System.out.println(allSubSequence("ape"));
		// System.out.println(allSubSequence3("ape"));
	}


	public int numMatchingSubseq(String S, String[] words) {
		int res = 0;
		for (String word : words) {
			if (isSubsequence(word, S)) {
				res++;
			}
		}
		return res;
    }

	public static boolean isSubsequence(String s, String t) {
		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i)==t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
    }

	/**
	 * 二分法，找到第一个比prefix值大的值
	 * @param s
	 * @param t
	 * @return
	 */
    public static boolean isSubsequence2(String s, String t) {
		Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>
		for (int i = 0; i < t.length(); i++) {
			char curr = t.charAt(i);
			if (!map.containsKey(curr)) {
				map.put(curr, new ArrayList<Integer>());
			}
			map.get(curr).add(i);
		}
		int prefix = -1;
		for (int i = 0; i < s.length(); i++) {
			char schar = s.charAt(i);
			if (!map.containsKey(schar)) {
				return false;
			} else {
				List<Integer> list = map.get(schar);
				prefix = binarysearch(list, prefix, 0, list.size() - 1);
				if (prefix == -1) {
					return false;
				}
				prefix++;
			}
		}
		return true;
	}

	private static int binarysearch(List<Integer> list, int prefix,int start,int end) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (list.get(mid) >= prefix) {
				if (mid == 0 || list.get(mid - 1) < prefix) {
					return list.get(mid);
				} else {
					end = mid - 1;
				}
			} else {
				start = mid + 1;
			}
		}
		return -1;
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
