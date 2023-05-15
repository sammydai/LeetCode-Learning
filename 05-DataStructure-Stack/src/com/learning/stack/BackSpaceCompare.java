package com.learning.stack;

import java.util.Stack;


/**
 * 删除空间比对
 *
 * @author Sammy
 * @date 2023/05/12
 */
public class BackSpaceCompare {
	public static void main(String[] args) {
		System.out.println(new BackSpaceCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
	}

	public boolean backspaceCompare(String S, String T) {
		Stack<Character> helperS = helper(S);
		Stack<Character> helperT = helper(T);
		if (helperS.size()!=helperT.size()) {
			return false;
		}
		while (!helperS.isEmpty()) {
			if (helperS.pop() != helperT.pop()) {
				return false;
			}
		}
		return true;
	}


	public Stack<Character> helper(String ss){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < ss.length(); i++) {
			if (ss.charAt(i) == '#' ) {
				if (stack.isEmpty()) continue;
				stack.pop();
			} else {
				stack.push(ss.charAt(i));
			}
		}
		return stack;
	}


}
