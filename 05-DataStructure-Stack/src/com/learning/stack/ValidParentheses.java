package com.learning.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Package: com.learning.stack
 * @Description: 20. Valid Parenthesesm
 * 				 921. Minimum Add to Make Parentheses Valid
 * @Author: Sammy
 * @Date: 2020/11/14 11:01
 */

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0 || s.length() % 2 != 0) {
			return false;
		}
		HashMap<Character,Character> set = new HashMap<>();
		set.put('(',')');
		set.put('{','}');
		set.put('[',']');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char compareCharacter = s.charAt(i);
			if (set.containsKey(compareCharacter)) {
				stack.push(compareCharacter);
			}else {
				if (stack.isEmpty()) {
					return false;
				} else {
					Character leftPair = stack.pop();
					if (set.get(leftPair) != compareCharacter) {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
    }

    public int minAddToMakeValid(String S) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (!stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
				} else {
					stack.push(')');
				}
			}
		}
		return stack.size();
	}

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().minAddToMakeValid("()))(("));
	}

	/**
	 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 An input string is valid if:
	 Open brackets must be closed by the same type of brackets.Open brackets must be closed in the correct order.
	 * @param s
	 * @return
	 */
	public boolean isValidV2(String s) {
		Map<Character, Character> cmap = new HashMap<>();
		cmap.put(')', '(');
		cmap.put(']', '[');
		cmap.put('}', '{');
		Stack<Character> stack = new Stack<>();
		if (s.length() % 2 != 0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (cc == '(' || cc == '{' || cc == '[') {
				stack.push(cc);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() != cmap.get(cc)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
}
