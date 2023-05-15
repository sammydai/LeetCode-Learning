package com.learning.stack;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * Input: s = "abbaca"
 * Output: "ca"
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/12 11:30]
 */
public class RemoveDuplicate {
	public static void main(String[] args) {
		System.out.println(new RemoveDuplicate().removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String s) {
		String res = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty() || stack.peek() != c) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
			res = stack.pop() + res;
		}

		return res;
	}
}
