package com.learning.slidewin;

import java.util.*;

/**
 * @Package: com.learning.slidewin
 * @Description: 3. Longest Substring Without Repeating Characters
 * @Author: Sammy
 * @Date: 2020/11/7 21:57
 */

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println("lengthOfLongestSubstring");
		System.out.println("------------------------");
		System.out.println(lengthOfLongestSubstringV2("adbccba"));
	}
	/**
	 * Given a string s, find the length of the longest substring without repeating characters.
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int maxResult = Integer.MIN_VALUE;
		List<List<String>> result = new ArrayList<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			List<String> tempResult = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int j = i; j<= n; j++){
				if ((j<n) && sb.indexOf(String.valueOf(s.charAt(j)))==-1){
					sb.append(String.valueOf(s.charAt(j)));
				}else {
					tempResult.add(sb.toString());
					maxResult = maxResult>sb.length()? maxResult:sb.length();
					result.add(tempResult);
					break;
				}
			}
		}
		System.out.println(result);
		return maxResult;
	}

	public static int lengthOfLongestSubstring1(String s) {
		int n = s.length();
		if (n ==0||s==null) return 0;
		if (n ==1) return 1;
		int maxResult = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j<= n; j++){
				if ((j<n)&& sb.indexOf(String.valueOf(s.charAt(j)))==-1){
					sb.append(String.valueOf(s.charAt(j)));
				}else {
					maxResult = maxResult>(j-i)? maxResult:(j-i);
					break;
				}
			}
		}
		return maxResult;
	}

	/**
	 * 在写亿遍: 滑动窗口 left，right概念
	 * Input: s = "abcabcbb"
	   Output: 3
	   Explanation: The answer is "abc", with the length of 3.

	 	Input: s = "pwwkew"
	 	Output: 3
		Explanation: The answer is "wke", with the length of 3.
	    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * @param s
	 * @return
	 */
	public static int 	lengthOfLongestSubstringV2(String s) {
		int n = s.length();
		if (n == 0 || s == null) {
			return 0;
		}
		if (n ==1) {
			return 1;
		}
		int maxResult = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>(256);
		int left = 0;
		int right;
		for (right = 0; right < n; right++) {
			char cc = s.charAt(right);
			if (map.containsKey(cc)) {
				maxResult = Math.max(right - left, maxResult);
				/**
				 * 获取重复值的位置，然后取值下一位，两个窗口指针必须向前，不能向后退
				 * 为什么要取left, map.get(cc) + 1的最大值
				 * 比如adbccba,当left=4 第二个c时，right=b（第二个），从map中查询出来，
				 * map.get(b)+1=3,如果不比较大小，那left指针就会往回找，出现错误，移动窗口必须往前走
				 */
				left = Math.max(left, map.get(cc) + 1);
			}
			map.put(cc, right);
		}
		return maxResult > right - left ? maxResult : right - left;
    }

	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		if (n ==0||s==null) return 0;
		if (n ==1) return 1;
		int maxResult = Integer.MIN_VALUE;
		Set<Character> sset = new HashSet<>(26);
		int i = 0;
		int j = 0;
		while (j<n){
			if (!sset.contains(s.charAt(j))) {
				sset.add(s.charAt(j));
				j++;
				maxResult = maxResult>sset.size()? maxResult:sset.size();
			}else {
				sset.remove(s.charAt(i));
				i++;
			}
		}
		return maxResult;
	}
}
