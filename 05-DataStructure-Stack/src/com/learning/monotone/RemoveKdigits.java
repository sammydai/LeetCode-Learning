package com.learning.monotone;

import java.util.Stack;

/**
 * @Package: com.learning.monotone
 * @Description: 402. Remove K Digits
 * @Author: Sammy
 * @Date: 2020/11/24 21:21
 */

public class RemoveKdigits {
	public static void main(String[] args) {
		System.out.println(removeKdigits("1234567890", 9));
	}

	/**
	 * 使用单调递增栈
	 * @param num
	 * @param k
	 * @return
	 */
	public static String removeKdigits(String num, int k) {
       if (k==num.length()) return "0";
		StringBuffer res = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);

			/**
			 * 关键点 while和if的区别
			 * 在1234567890这个情况下，只会移除第一个数字
			 * 必须要循环移除k个，比正在进入栈内的数字大的
 			 */

			// if (!stack.isEmpty() && k > 0 && stack.peek() > c) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}
		while (k> 0 && !stack.isEmpty()) {
			stack.pop();
			k--;
		}
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		String ss = res.reverse().toString();
		while (ss.startsWith("0")&&ss.length()>1) {
			ss =ss.substring(1);
		}
		if (ss.length()==0) return "0";
		return ss;
	}

	public static String removeKdigits2(String num, int k) {
		int len = num.length();
		//corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < num.length()) {
			//whenever meet a digit which is less than the previous digit, discard the previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		//construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		//remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}
}
