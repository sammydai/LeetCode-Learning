package com.learning.slidewin;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;

/**
 * @Package: com.learning.slidewin
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/7 21:57
 */

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println("lengthOfLongestSubstring");
		System.out.println("------------------------");
		System.out.println(lengthOfLongestSubstring2("au"));
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
